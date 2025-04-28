package com.pfa.service.impl;

import com.pfa.dto.UtilisateurDTO;
import com.pfa.entity.Utilisateur;
import com.pfa.exception.ResourceNotFoundException;
import com.pfa.repository.UtilisateurRepository;
import com.pfa.Service.UtilisateurService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public abstract class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDTO createUtilisateur(UtilisateurDTO dto) {
        Utilisateur user = new Utilisateur();
        user.setNom(dto.getNom());
        user.setEmail(dto.getEmail());
        user.setMotDePasse(dto.getMotDePasse());
        return convertToDTO(utilisateurRepository.save(user));
    }

    @Override
    public UtilisateurDTO updateUtilisateur(Integer id, UtilisateurDTO dto) {
        Utilisateur user = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé ID: " + id));

        user.setNom(dto.getNom());
        user.setEmail(dto.getEmail());
        return convertToDTO(utilisateurRepository.save(user));
    }

    @Override
    public void deleteUtilisateur(Integer id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public UtilisateurDTO getUtilisateurById(Integer id) {
        return utilisateurRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé ID: " + id));
    }

    @Override
    public List<UtilisateurDTO> getAllUtilisateurs() {
        return utilisateurRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UtilisateurDTO convertToDTO(Utilisateur user) {
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setId(Math.toIntExact(Utilisateur.getId()));
        dto.setNom(user.getNom());
        dto.setEmail(user.getEmail());
        return dto;
    }
}