package com.pfa.Service;

import com.pfa.dto.SujetDTO;
import java.util.List;

public interface SujetService {
    SujetDTO proposerSujet(SujetDTO sujetDTO);
    static List<SujetDTO> getSujetsDisponibles();
    boolean verifierDisponibilite(Integer sujetId);
    void validerSujet(Integer sujetId);
}