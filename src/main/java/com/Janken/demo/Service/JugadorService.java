package com.Janken.demo.Service;

import com.Janken.demo.Entity.Jugador;
import com.Janken.demo.Repository.JugadorRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository repository;

    // =========================
    // GUARDAR RECORD (MEJORADO)
    // =========================
    public void guardarRecord(String nombre, int victorias) {

        Optional<Jugador> existente = repository.findByNombre(nombre);

        if (existente.isPresent()) {

            Jugador jugador = existente.get();

            // SOLO ACTUALIZA SI ES MEJOR
            if (victorias > jugador.getVictorias()) {
                jugador.setVictorias(victorias);
                repository.save(jugador);
            }

        } else {
            // si no existe, lo crea
            Jugador nuevo = new Jugador(nombre, victorias);
            repository.save(nuevo);
        }
    }

    // =========================
    // BUSCAR POR NOMBRE (NUEVO)
    // =========================
    public Optional<Jugador> buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }
    public java.util.List<Jugador> obtenerTodos() {
    return repository.findAll();
}
   public List<Jugador> obtenerRanking() {
    return repository.findAll()
            .stream()
            .sorted((a, b) -> b.getVictorias() - a.getVictorias())
            .toList();
}
}