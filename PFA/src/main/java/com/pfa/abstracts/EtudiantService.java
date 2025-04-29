package com.pfa.abstracts;

import com.pfa.dto.EtudiantDTO;
import com.pfa.model.Etudiant;

import java.util.List;

public interface EtudiantService {
    Etudiant createEtudiant(EtudiantDTO dto);

    Etudiant getEtudiantById(Integer id);

    List<Etudiant> getAllEtudiants();

    Etudiant updateEtudiant(Integer id, EtudiantDTO dto);

    void deleteEtudiant(Integer id);
}