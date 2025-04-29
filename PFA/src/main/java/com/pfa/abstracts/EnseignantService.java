package com.pfa.abstracts;

import com.pfa.dto.EnseignantDTO;
import com.pfa.model.Enseignant;

import java.util.List;

public interface EnseignantService {
    Enseignant createEnseignant(EnseignantDTO dto);

    Enseignant getEnseignantById(Integer id);

    List<Enseignant> getAllEnseignants();

    Enseignant updateEnseignant(Integer id, EnseignantDTO dto);

    void deleteEnseignant(Integer id);
}
