package com.pfa.Service;

import com.pfa.dto.SujetDTO;
import com.pfa.dto.SujetProposeDTO;
import com.pfa.dto.UtilisateurDTO;
import java.util.List;

public interface UtilisateurService {
    UtilisateurDTO createUser(UtilisateurDTO userDTO);
    UtilisateurDTO updateUser(Integer id, UtilisateurDTO userDTO);
    void deleteUser(Integer id);
    UtilisateurDTO getUserById(Integer id);
    List<UtilisateurDTO> getAllUsers();

    SujetDTO proposerSujet(Integer userId, SujetProposeDTO sujetDTO);

    void deleteUtilisateur(Integer id);

    UtilisateurDTO getUtilisateurById(Integer id);

    List<UtilisateurDTO> getAllUtilisateurs();
}