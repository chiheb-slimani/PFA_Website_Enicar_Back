package com.pfa.Service;

import com.pfa.entity.Admin;
import com.pfa.entity.Sujet;
import com.pfa.entity.Utilisateur;
import com.pfa.exception.ResourceNotFoundException;
import com.pfa.repository.AdminRepository;
import com.pfa.repository.SujetRepository;
import com.pfa.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public abstract class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final SujetRepository sujetRepository;

    public AdminServiceImpl(
            AdminRepository adminRepository,
            UtilisateurRepository utilisateurRepository,
            SujetRepository sujetRepository
    ) {
        this.adminRepository = adminRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.sujetRepository = sujetRepository;
    }

    @Override
    public void gererDroitsUtilisateur(Integer adminId, Integer userId, String role) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin non trouvé"));

        Utilisateur user = utilisateurRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé"));

        user.setRole(role);
        utilisateurRepository.save(user);
    }

    @Override
    public void validerSujet(Integer sujetId) {
        Sujet sujet = sujetRepository.findById(sujetId)
                .orElseThrow(() -> new ResourceNotFoundException("Sujet non trouvé"));
        sujet.setStatut("VALIDÉ");
        sujetRepository.save(sujet);
    }

    @Override
    public void supprimerUtilisateur(Integer userId) {
        if (utilisateurRepository.existsById(userId)) utilisateurRepository.deleteById(userId);
        else {
            throw new ResourceNotFoundException("Utilisateur non trouvé");
        }
    }
}