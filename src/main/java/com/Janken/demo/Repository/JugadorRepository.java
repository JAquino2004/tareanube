package com.Janken.demo.Repository;

import com.Janken.demo.Entity.Jugador;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    Optional<Jugador> findByNombre(String nombre);

}