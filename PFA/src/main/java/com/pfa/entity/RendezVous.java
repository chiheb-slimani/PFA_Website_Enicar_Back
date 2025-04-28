package com.pfa.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "rendezvous")
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private LocalTime heure;
    private String description;

    @ManyToOne
    @JoinColumn(name = "binome_id")
    private Binome binome;

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public String getDescription() {
        return description;
    }

    public Binome getBinome() {
        return binome;
    }

    public void setBinome(Binome binome) {
        this.binome = binome;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}