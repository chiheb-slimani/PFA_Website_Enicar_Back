package com.pfa.repo;

import com.pfa.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {
    boolean existsByEmail(String email);
}
