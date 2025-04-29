package com.pfa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "enseignant")
@PrimaryKeyJoinColumn(name = "id")
@Data
public class Enseignant extends Utilisateur {
    private String filiere;
}
