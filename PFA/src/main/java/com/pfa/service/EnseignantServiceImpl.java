package com.pfa.service;

import com.pfa.Shared.CustomResponseException;
import com.pfa.abstracts.EnseignantService;
import com.pfa.dto.EnseignantDTO;
import com.pfa.model.Enseignant;
import com.pfa.repo.EnseignantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantServiceImpl implements EnseignantService {

    private final EnseignantRepository enseignantRepository;

    public EnseignantServiceImpl(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public Enseignant createEnseignant(EnseignantDTO dto) {
        if (enseignantRepository.existsByEmail(dto.getEmail())) {
            throw CustomResponseException.BadRequest("Email déjà utilisé");
        }
        Enseignant e = new Enseignant();
        e.setNom(dto.getNom());
        e.setEmail(dto.getEmail());
        e.setMotDePasse(dto.getMotDePasse());
        e.setFiliere(dto.getFiliere());
        return enseignantRepository.save(e);
    }

    @Override
    public Enseignant getEnseignantById(Integer id) {
        return enseignantRepository.findById(id)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Enseignant non trouvé avec id: " + id));
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        List<Enseignant> list = enseignantRepository.findAll();
        if (list.isEmpty()) {
            throw CustomResponseException.ResourceNotFound("Aucun enseignant trouvé");
        }
        return list;
    }

    @Override
    public Enseignant updateEnseignant(Integer id, EnseignantDTO dto) {
        Enseignant existing = enseignantRepository.findById(id)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Enseignant non trouvé avec id: " + id));

        if (!existing.getEmail().equals(dto.getEmail()) && enseignantRepository.existsByEmail(dto.getEmail())) {
            throw CustomResponseException.BadRequest("Email déjà utilisé par un autre enseignant");
        }

        existing.setNom(dto.getNom());
        existing.setEmail(dto.getEmail());
        existing.setMotDePasse(dto.getMotDePasse());
        existing.setFiliere(dto.getFiliere());
        return enseignantRepository.save(existing);
    }

    @Override
    public void deleteEnseignant(Integer id) {
        if (!enseignantRepository.existsById(id)) {
            throw CustomResponseException.ResourceNotFound("Enseignant non trouvé avec id: " + id);
        }
        enseignantRepository.deleteById(id);
    }
}