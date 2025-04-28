package com.pfa.repository;

import com.pfa.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    // méthodes custom possibles, ex: findByEmail
    Utilisateur findByEmail(String email);
}