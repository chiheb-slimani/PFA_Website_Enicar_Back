package com.pfa.service;

import com.pfa.Shared.CustomResponseException;
import com.pfa.abstracts.SujetProposeService;
import com.pfa.dto.SujetProposeDTO;
import com.pfa.model.Enseignant;
import com.pfa.model.SujetPropose;
import com.pfa.repo.EnseignantRepository;
import com.pfa.repo.SujetProposeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SujetProposeServiceImpl implements SujetProposeService {
    private final SujetProposeRepository repo;
    private final EnseignantRepository enseignantRepo;

    public SujetProposeServiceImpl(SujetProposeRepository repo, EnseignantRepository enseignantRepo) {
        this.repo = repo;
        this.enseignantRepo = enseignantRepo;
    }

    @Override
    public SujetPropose createSujetPropose(SujetProposeDTO dto) {
        SujetPropose sp = new SujetPropose();
        sp.setTitre(dto.getTitre());
        sp.setDescription(dto.getDescription());
        sp.setStatut(dto.getStatut());
        sp.setFiliere(dto.getFiliere());
        Enseignant enc = enseignantRepo.findById(dto.getEncadrantId())
                .orElseThrow(() -> CustomResponseException.BadRequest("Enseignant introuvable"));
        sp.setEncadrant(enc);
        sp.setDateProposition(dto.getDateProposition());
        return repo.save(sp);
    }

    @Override
    public SujetPropose getSujetProposeById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Sujet proposé non trouvé avec id: " + id));
    }

    @Override
    public List<SujetPropose> getAllSujetsProposes() {
        List<SujetPropose> list = repo.findAll();
        if (list.isEmpty()) {
            throw CustomResponseException.ResourceNotFound("Aucun sujet proposé trouvé");
        }
        return list;
    }

    @Override
    public SujetPropose updateSujetPropose(Integer id, SujetProposeDTO dto) {
        SujetPropose sp = getSujetProposeById(id);
        sp.setTitre(dto.getTitre());
        sp.setDescription(dto.getDescription());
        sp.setStatut(dto.getStatut());
        sp.setFiliere(dto.getFiliere());
        Enseignant enc = enseignantRepo.findById(dto.getEncadrantId())
                .orElseThrow(() -> CustomResponseException.BadRequest("Enseignant introuvable"));
        sp.setEncadrant(enc);
        sp.setDateProposition(dto.getDateProposition());
        return repo.save(sp);
    }

    @Override
    public void deleteSujetPropose(Integer id) {
        if (!repo.existsById(id)) {
            throw CustomResponseException.ResourceNotFound("Sujet proposé non trouvé avec id: " + id);
        }
        repo.deleteById(id);
    }
}