package com.pfa.service;

import com.pfa.Shared.CustomResponseException;
import com.pfa.abstracts.SujetService;
import com.pfa.dto.SujetDTO;
import com.pfa.model.Enseignant;
import com.pfa.model.Sujet;
import com.pfa.repo.EnseignantRepository;
import com.pfa.repo.SujetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SujetServiceImpl implements SujetService {
    private final SujetRepository sujetRepo;
    private final EnseignantRepository enseignantRepo;

    public SujetServiceImpl(SujetRepository sujetRepo, EnseignantRepository enseignantRepo) {
        this.sujetRepo = sujetRepo;
        this.enseignantRepo = enseignantRepo;
    }

    @Override
    public Sujet createSujet(SujetDTO dto) {
        Sujet s = new Sujet();
        s.setTitre(dto.getTitre());
        s.setDescription(dto.getDescription());
        s.setStatut(dto.getStatut());
        s.setFiliere(dto.getFiliere());
        Enseignant enc = enseignantRepo.findById(dto.getEncadrantId())
                .orElseThrow(() -> CustomResponseException.BadRequest("Enseignant introuvable"));
        s.setEncadrant(enc);
        return sujetRepo.save(s);
    }

    @Override
    public Sujet getSujetById(Integer id) {
        return sujetRepo.findById(id)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Sujet non trouvé avec id: " + id));
    }

    @Override
    public List<Sujet> getAllSujets() {
        List<Sujet> list = sujetRepo.findAll();
        if (list.isEmpty()) {
            throw CustomResponseException.ResourceNotFound("Aucun sujet trouvé");
        }
        return list;
    }

    @Override
    public Sujet updateSujet(Integer id, SujetDTO dto) {
        Sujet s = getSujetById(id);
        s.setTitre(dto.getTitre());
        s.setDescription(dto.getDescription());
        s.setStatut(dto.getStatut());
        s.setFiliere(dto.getFiliere());
        Enseignant enc = enseignantRepo.findById(dto.getEncadrantId())
                .orElseThrow(() -> CustomResponseException.BadRequest("Enseignant introuvable"));
        s.setEncadrant(enc);
        return sujetRepo.save(s);
    }

    @Override
    public void deleteSujet(Integer id) {
        if (!sujetRepo.existsById(id)) {
            throw CustomResponseException.ResourceNotFound("Sujet non trouvé avec id: " + id);
        }
        sujetRepo.deleteById(id);
    }
}
