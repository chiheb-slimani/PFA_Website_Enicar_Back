package com.pfa.Service;

import com.pfa.dto.SujetDTO;
import com.pfa.entity.Sujet;
import com.pfa.exception.ResourceNotFoundException;
import com.pfa.repository.SujetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SujetServiceImpl implements SujetService {

    private final SujetRepository sujetRepository;

    public SujetServiceImpl(SujetRepository sujetRepository) {
        this.sujetRepository = sujetRepository;
    }

    @Override
    public SujetDTO createSujet(SujetDTO sujetDTO) {
        Sujet sujet = new Sujet();
        sujet.setTitre(sujetDTO.getTitre());
        sujet.setDescription(sujetDTO.getDescription());
        sujet.setStatut("PROPOSÉ");
        return convertToDTO(sujetRepository.save(sujet));
    }

    @Override
    public List<SujetDTO> getSujetsDisponibles() {
        return sujetRepository.findByStatut("DISPONIBLE")
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void validerSujet(Integer sujetId) {
        Sujet sujet = sujetRepository.findById(sujetId)
                .orElseThrow(() -> new ResourceNotFoundException("Sujet non trouvé"));
        sujet.setStatut("VALIDÉ");
        sujetRepository.save(sujet);
    }

    private SujetDTO convertToDTO(Sujet sujet) {
        return new SujetDTO(
                Sujet.getId(),
                sujet.getTitre(),
                sujet.getDescription(),
                sujet.getStatut(),
                sujet.getEncadrant() != null ? sujet.getEncadrant().getId() : null
        );
    }
}