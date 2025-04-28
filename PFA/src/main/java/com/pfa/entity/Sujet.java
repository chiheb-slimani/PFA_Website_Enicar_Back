package com.pfa.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "sujets")
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String description;
    private String statut;
    private String nombreComplementaire;
    private String filiere;

    @ManyToOne
    @JoinColumn(name = "encadrant_id")
    private Enseignant encadrant;

    @OneToMany(mappedBy = "sujet")
    private List<SujetPropose> propositions;

    public static Integer getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getStatut() {
        return statut;
    }

    public String getNombreComplementaire() {
        return nombreComplementaire;
    }

    public String getFiliere() {
        return filiere;
    }

    public Enseignant getEncadrant() {
        return encadrant;
    }

    public List<SujetPropose> getPropositions() {
        return propositions;
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

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setNombreComplementaire(String nombreComplementaire) {
        this.nombreComplementaire = nombreComplementaire;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public void setEncadrant(Enseignant encadrant) {
        this.encadrant = encadrant;
    }

    public void setPropositions(List<SujetPropose> propositions) {
        this.propositions = propositions;
    }
}