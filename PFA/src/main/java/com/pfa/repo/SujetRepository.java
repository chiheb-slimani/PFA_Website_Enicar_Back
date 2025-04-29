package com.pfa.repo;

import com.pfa.model.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SujetRepository extends JpaRepository<Sujet, Integer> {
}
