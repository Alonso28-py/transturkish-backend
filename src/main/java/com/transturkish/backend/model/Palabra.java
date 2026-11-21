package com.transturkish.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Palabra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String turco;
    private String espanol;

    public Palabra() {
}

    // Constructor para crear una palabra
    public Palabra(String turco, String espanol) {
        this.turco = turco;
        this.espanol = espanol;
    }

    // Obtener el ID
    public Long getId() {
        return id;
    }

    // Obtener la palabra en turco
    public String getTurco() {
        return turco;
    }

    // Modificar la palabra en turco
    public void setTurco(String turco) {
        this.turco = turco;
    }

    // Obtener la traducción al español
    public String getEspanol() {
        return espanol;
    }

    // Modificar la traducción al español
    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

}