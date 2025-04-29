package com.pfa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sujet")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String description;
    private String statut;
    private String filiere;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant encadrant;
}