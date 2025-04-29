package com.pfa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="admin")
@Data
public class Admin {
    @Id
    private int numero;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
}