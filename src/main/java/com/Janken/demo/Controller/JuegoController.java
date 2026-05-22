package com.Janken.demo.Controller;

import com.Janken.demo.Logic.Janken;
import com.Janken.demo.Service.JugadorService;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.Janken.demo.Entity.Jugador;

@RestController
@RequestMapping("/juego")
public class JuegoController {

    @Autowired
    private JugadorService jugadorService;

    private Janken janken = new Janken();

    

    
@PostMapping("/jugar")
public String jugar(
        @RequestParam String nombre,
        @RequestParam int jugador,
        @RequestParam int victoriasActuales
) {

    Random random = new Random();

    int oponente = random.nextInt(3) + 1;

    int resultado = janken.calcular(jugador, oponente);

    String mensaje;

    if (resultado == 5) {

        // verificar record antes de guardar
        var jugadorBD = jugadorService.buscarPorNombre(nombre);

        if (jugadorBD.isPresent()) {

            if (victoriasActuales > jugadorBD.get().getVictorias()) {
                jugadorService.guardarRecord(nombre, victoriasActuales);
                mensaje = "Perdiste. Nuevo record guardado";
            } else {
                mensaje = "Perdiste. No superaste el record";
            }

        } else {
            jugadorService.guardarRecord(nombre, victoriasActuales);
            mensaje = "Perdiste. Primer record guardado";
        }

    } else if (resultado == 4) {
        mensaje = "Ganaste";
    } else {
        mensaje = "Empate";
    }

    return mensaje + "|" + oponente;
}

@GetMapping("/ranking")
public List<Jugador> ranking() {
    return jugadorService.obtenerRanking();
}
}