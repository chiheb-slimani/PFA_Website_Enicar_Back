package com.pfa.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "taches")
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String description;
    private LocalDate date;
    private LocalTime temps;

    @ManyToOne
    @JoinColumn(name = "binome_id")
    private Binome binome;

    public Integer getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTemps() {
        return temps;
    }

    public Binome getBinome() {
        return binome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTemps(LocalTime temps) {
        this.temps = temps;
    }

    public void setBinome(Binome binome) {
        this.binome = binome;
    }
}