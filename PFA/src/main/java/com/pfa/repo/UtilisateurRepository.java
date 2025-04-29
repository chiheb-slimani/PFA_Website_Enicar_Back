package com.pfa.repo;

import com.pfa.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    // vous pouvez ajouter des méthodes custom, ex.:
    // boolean existsByEmail(String email);
}