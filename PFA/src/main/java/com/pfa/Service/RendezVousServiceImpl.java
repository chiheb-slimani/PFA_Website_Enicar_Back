package com.pfa.service.impl;

import com.pfa.dto.RendezVousDTO;
import com.pfa.entity.RendezVous;
import com.pfa.exception.ResourceNotFoundException;
import com.pfa.repository.RendezVousRepository;
import com.pfa.service.RendezVousService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RendezVousServiceImpl implements RendezVousService {

    private final RendezVousRepository rendezVousRepository;

    public RendezVousServiceImpl(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public RendezVousDTO createRendezVous(RendezVousDTO dto) {
        RendezVous rdv = new RendezVous();
        rdv.setDate(dto.getDate());
        rdv.setHeure(dto.getHeure());
        rdv.setDescription(dto.getDescription());
        return convertToDTO(rendezVousRepository.save(rdv));
    }

    @Override
    public void annulerRendezVous(Integer id) {
        rendezVousRepository.deleteById(id);
    }

    private RendezVousDTO convertToDTO(RendezVous rdv) {
        RendezVousDTO dto = new RendezVousDTO();
        dto.setId(rdv.getId());
        dto.setDate(rdv.getDate());
        dto.setHeure(rdv.getHeure());
        dto.setDescription(rdv.getDescription());
        return dto;
    }
}