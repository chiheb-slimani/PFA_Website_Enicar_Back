package com.pfa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "binome")
@Data
public class Binome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private float moyenneTotale;

    @ManyToOne
    @JoinColumn(name = "sujet_valide_id")
    private Sujet sujetValide;

    @ManyToMany
    @JoinTable(
            name = "binome_etudiant",
            joinColumns = @JoinColumn(name = "binome_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )
    private List<Etudiant> etudiants;
}