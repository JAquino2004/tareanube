# ===== ETAPA 1: BUILD =====
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copiar pom primero (mejor cache)
COPY pom.xml .

# Descargar dependencias
RUN mvn dependency:go-offline

# Copiar código fuente
COPY src ./src

# Compilar JAR
RUN mvn clean package -DskipTests

# ===== ETAPA 2: RUNTIME =====
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiar JAR desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Puerto de Render
EXPOSE 8080

# Ejecutar aplicación
ENTRYPOINT ["java","-jar","app.jar"]
