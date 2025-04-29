package com.pfa.abstracts;

import com.pfa.dto.UtilisateurDTO;
import com.pfa.model.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur createUtilisateur(UtilisateurDTO dto);

    Utilisateur getUtilisateurById(Integer id);

    List<Utilisateur> getAllUtilisateurs();

    Utilisateur updateUtilisateur(Integer id, UtilisateurDTO dto);

    void deleteUtilisateur(Integer id);
}