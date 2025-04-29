package com.pfa.service;

import com.pfa.Shared.CustomResponseException;
import com.pfa.abstracts.UtilisateurService;
import com.pfa.dto.UtilisateurDTO;
import com.pfa.model.Utilisateur;
import com.pfa.repo.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Utilisateur createUtilisateur(UtilisateurDTO dto) {
        // Vérifier unicité, ex. si email existant :
        // if(utilisateurRepository.existsByEmail(dto.getEmail())) {
        //     throw CustomResponseException.BadRequest("Email déjà utilisé");
        // }
        Utilisateur u = new Utilisateur();
        u.setNom(dto.getNom());
        u.setEmail(dto.getEmail());
        u.setMotDePasse(dto.getMotDePasse());
        return utilisateurRepository.save(u);
    }

    @Override
    public Utilisateur getUtilisateurById(Integer id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Utilisateur non trouvé avec id: " + id));
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        List<Utilisateur> list = utilisateurRepository.findAll();
        if (list.isEmpty()) {
            throw CustomResponseException.ResourceNotFound("Aucun utilisateur trouvé");
        }
        return list;
    }

    @Override
    public Utilisateur updateUtilisateur(Integer id, UtilisateurDTO dto) {
        Utilisateur existing = utilisateurRepository.findById(id)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Utilisateur non trouvé avec id: " + id));
        existing.setNom(dto.getNom());
        existing.setEmail(dto.getEmail());
        existing.setMotDePasse(dto.getMotDePasse());
        return utilisateurRepository.save(existing);
    }

    @Override
    public void deleteUtilisateur(Integer id) {
        if (!utilisateurRepository.existsById(id)) {
            throw CustomResponseException.ResourceNotFound("Utilisateur non trouvé avec id: " + id);
        }
        utilisateurRepository.deleteById(id);
    }
}