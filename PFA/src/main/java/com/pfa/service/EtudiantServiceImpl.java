package com.pfa.service;

import com.pfa.Shared.CustomResponseException;
import com.pfa.abstracts.EtudiantService;
import com.pfa.dto.EtudiantDTO;
import com.pfa.model.Etudiant;
import com.pfa.model.Sujet;
import com.pfa.repo.EtudiantRepository;
import com.pfa.repo.SujetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etuRepo;
    private final SujetRepository sujetRepo;

    public EtudiantServiceImpl(EtudiantRepository etuRepo, SujetRepository sujetRepo) {
        this.etuRepo = etuRepo;
        this.sujetRepo = sujetRepo;
    }

    @Override
    public Etudiant createEtudiant(EtudiantDTO dto) {
        Etudiant e = new Etudiant();
        e.setNom(dto.getNom());
        e.setEmail(dto.getEmail());
        e.setMotDePasse(dto.getMotDePasse());
        e.setMoyenne(dto.getMoyenne());
        if (dto.getSujetId() != null) {
            Sujet s = sujetRepo.findById(dto.getSujetId())
                    .orElseThrow(() -> CustomResponseException.BadRequest("Sujet introuvable"));
            e.setSujet(s);
        }
        if (dto.getBinomeId() != null) {
            Etudiant b = etuRepo.findById(dto.getBinomeId())
                    .orElseThrow(() -> CustomResponseException.BadRequest("Binome introuvable"));
            e.setBinome(b);
        }
        return etuRepo.save(e);
    }

    @Override
    public Etudiant getEtudiantById(Integer id) {
        return etuRepo.findById(id)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Etudiant non trouvé avec id: " + id));
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        List<Etudiant> list = etuRepo.findAll();
        if (list.isEmpty()) throw CustomResponseException.ResourceNotFound("Aucun étudiant trouvé");
        return list;
    }

    @Override
    public Etudiant updateEtudiant(Integer id, EtudiantDTO dto) {
        Etudiant e = getEtudiantById(id);
        e.setNom(dto.getNom());
        e.setEmail(dto.getEmail());
        e.setMotDePasse(dto.getMotDePasse());
        e.setMoyenne(dto.getMoyenne());
        if (dto.getSujetId() != null) {
            Sujet s = sujetRepo.findById(dto.getSujetId())
                    .orElseThrow(() -> CustomResponseException.BadRequest("Sujet introuvable"));
            e.setSujet(s);
        } else e.setSujet(null);
        if (dto.getBinomeId() != null) {
            Etudiant b = etuRepo.findById(dto.getBinomeId())
                    .orElseThrow(() -> CustomResponseException.BadRequest("Binome introuvable"));
            e.setBinome(b);
        } else e.setBinome(null);
        return etuRepo.save(e);
    }

    @Override
    public void deleteEtudiant(Integer id) {
        if (!etuRepo.existsById(id))
            throw CustomResponseException.ResourceNotFound("Etudiant non trouvé avec id: " + id);
        etuRepo.deleteById(id);
    }
}