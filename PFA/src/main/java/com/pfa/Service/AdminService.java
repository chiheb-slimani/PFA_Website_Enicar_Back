package com.pfa.Service;

import com.pfa.dto.SujetDTO;

public interface AdminService {
    void gererDroitsUtilisateur(Integer adminId, Integer userId, String role);

    static SujetDTO validerSujet(Integer adminId, Integer sujetId) {
        return null;
    }

    void supprimerUtilisateur(Integer adminId, Integer userId);

    void validerSujet(Integer sujetId);

    void supprimerUtilisateur(Integer userId);
}