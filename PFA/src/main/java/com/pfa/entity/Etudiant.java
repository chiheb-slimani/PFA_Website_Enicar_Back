package com.pfa.entity;

import jakarta.persistence.*;

@Table(name = "etudiants")
public class Etudiant extends Utilisateur {
    private Float moyenne;

    @ManyToOne
    @JoinColumn(name = "sujet_id")
    private Sujet sujet;

    @OneToOne
    @JoinColumn(name = "binome_id")
    private Etudiant binome;

    public Float getMoyenne() {
        return moyenne;
    }

    public Sujet getSujet() {
        return sujet;
    }

    public Etudiant getBinome() {
        return binome;
    }

    public void setMoyenne(Float moyenne) {
        this.moyenne = moyenne;
    }

    public void setSujet(Sujet sujet) {
        this.sujet = sujet;
    }

    public void setBinome(Etudiant binome) {
        this.binome = binome;
    }
}