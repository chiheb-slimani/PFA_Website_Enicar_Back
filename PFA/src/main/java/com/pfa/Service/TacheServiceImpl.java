package com.pfa.service;

import com.pfa.dto.TacheDTO;
import com.pfa.entity.Tache;
import com.pfa.exception.ResourceNotFoundException;
import com.pfa.repository.TacheRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class TacheServiceImpl implements TacheService {

    private final TacheRepository tacheRepository;

    public TacheServiceImpl(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    @Override
    public TacheDTO createTache(TacheDTO tacheDTO) {
        Tache tache = new Tache();
        tache.setTitre(tacheDTO.getTitre());
        tache.setDescription(tacheDTO.getDescription());
        tache.setDate(tacheDTO.getDate());
        return convertToDTO(tacheRepository.save(tache));
    }

    @Override
    public TacheDTO updateDateTache(Integer tacheId, LocalDate newDate) {
        Tache tache = tacheRepository.findById(tacheId)
                .orElseThrow(() -> new ResourceNotFoundException("Tâche non trouvée"));
        tache.setDate(newDate);
        return convertToDTO(tacheRepository.save(tache));
    }

    @Override
    public void deleteTache(Integer tacheId) {
        tacheRepository.deleteById(tacheId);
    }

    private TacheDTO convertToDTO(Tache tache) {
        return new TacheDTO(
                tache.getId(),
                tache.getTitre(),
                tache.getDescription(),
                tache.getDate()
        );
    }
}