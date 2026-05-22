package com.Janken.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nombre;

    private int victorias;

    public Jugador() {
    }

    public Jugador(String nombre, int victorias) {
        this.nombre = nombre;
        this.victorias = victorias;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }
}