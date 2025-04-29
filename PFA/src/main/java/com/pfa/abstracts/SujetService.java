package com.pfa.abstracts;

import com.pfa.dto.SujetDTO;
import com.pfa.model.Sujet;

import java.util.List;

public interface SujetService {
    Sujet createSujet(SujetDTO dto);

    Sujet getSujetById(Integer id);

    List<Sujet> getAllSujets();

    Sujet updateSujet(Integer id, SujetDTO dto);

    void deleteSujet(Integer id);
}