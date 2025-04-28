package com.pfa.repository;

import com.pfa.entity.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SujetRepository extends JpaRepository<Sujet, Integer> {
}