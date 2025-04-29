package com.pfa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "etudiant")
@PrimaryKeyJoinColumn(name = "id")
@Data
@EqualsAndHashCode(callSuper = true)
public class Etudiant extends Utilisateur {
    private float moyenne;

    @ManyToOne
    @JoinColumn(name = "sujet_id")
    private Sujet sujet;

    @OneToOne
    @JoinColumn(name = "binome_id")
    private Etudiant binome;
}