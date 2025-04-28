package com.pfa.Service;

import com.pfa.dto.EtudiantDTO;
import com.pfa.entity.Binome;
import com.pfa.entity.Etudiant;
import com.pfa.entity.Sujet;
import com.pfa.exception.ResourceNotFoundException;
import com.pfa.repository.BinomeRepository;
import com.pfa.repository.EtudiantRepository;
import com.pfa.repository.SujetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final BinomeRepository binomeRepository;
    private final SujetRepository sujetRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository,
                               BinomeRepository binomeRepository,
                               SujetRepository sujetRepository) {
        this.etudiantRepository = etudiantRepository;
        this.binomeRepository = binomeRepository;
        this.sujetRepository = sujetRepository;
    }

    @Override
    public void ajouterBinome(Integer etudiantId, Integer binomeId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant non trouvé"));

        Binome binome = binomeRepository.findById(binomeId)
                .orElseThrow(() -> new ResourceNotFoundException("Binôme non trouvé"));

        etudiant.setBinome(binome);
        etudiantRepository.save(etudiant);
    }

    @Override
    public void choisirSujet(Integer etudiantId, Integer sujetId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant non trouvé"));

        Sujet sujet = sujetRepository.findById(sujetId)
                .orElseThrow(() -> new ResourceNotFoundException("Sujet non trouvé"));

        etudiant.setSujet(sujet);
        sujet.setStatut("ATTRIBUÉ");
        etudiantRepository.save(etudiant);
        sujetRepository.save(sujet);
    }

    @Override
    public EtudiantDTO getEtudiant(Integer id) {
        return etudiantRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant non trouvé"));
    }

    private EtudiantDTO convertToDTO(Etudiant etudiant) {
        return new EtudiantDTO(
                etudiant.getId(),
                etudiant.getNom(),
                etudiant.getMoyenne(),
                etudiant.getSujet() != null ? etudiant.getSujet().getId() : null,
                etudiant.getBinome() != null ? etudiant.getBinome().getId() : null
        );
    }
}