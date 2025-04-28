package com.pfa.entity;

import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.GenerationType.*;

@Table(name = "binomes")
public class Binome {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private Float moyenneTotale;

    @OneToOne
    @JoinColumn(name = "sujet_valide_id")
    private Sujet sujetValide;

    @OneToMany(mappedBy = "binome")
    private List<SujetPropose> sujetsProposes;

    @ManyToMany
    @JoinTable(
            name = "binome_etudiants",
            joinColumns = @JoinColumn(name = "binome_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id"))
    private List<Etudiant> etudiants;

    public Integer getId() {
        return id;
    }

    public Float getMoyenneTotale() {
        return moyenneTotale;
    }

    public Sujet getSujetValide() {
        return sujetValide;
    }

    public List<SujetPropose> getSujetsProposes() {
        return sujetsProposes;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMoyenneTotale(Float moyenneTotale) {
        this.moyenneTotale = moyenneTotale;
    }

    public void setSujetValide(Sujet sujetValide) {
        this.sujetValide = sujetValide;
    }

    public void setSujetsProposes(List<SujetPropose> sujetsProposes) {
        this.sujetsProposes = sujetsProposes;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}