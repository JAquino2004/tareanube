package com.Janken.demo.Logic;

public class Janken {

    //1=piedra
    //2=papel
    //3=tijera
    //4=victoria
    //5=derrota
    //6=empate

    public Janken() {

    }

    public int calcular(int jugador, int oponente) {

        if (jugador == 1 && oponente == 1) return 6;
        if (jugador == 1 && oponente == 2) return 5;
        if (jugador == 1 && oponente == 3) return 4;

        if (jugador == 2 && oponente == 1) return 4;
        if (jugador == 2 && oponente == 2) return 6;
        if (jugador == 2 && oponente == 3) return 5;

        if (jugador == 3 && oponente == 1) return 5;
        if (jugador == 3 && oponente == 2) return 4;
        if (jugador == 3 && oponente == 3) return 6;

        return 0;
    }
}