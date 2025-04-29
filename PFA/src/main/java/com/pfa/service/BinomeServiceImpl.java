package com.pfa.service;

import com.pfa.Shared.CustomResponseException;
import com.pfa.abstracts.BinomeService;
import com.pfa.dto.BinomeDTO;
import com.pfa.model.Binome;
import com.pfa.model.Etudiant;
import com.pfa.model.Sujet;
import com.pfa.repo.BinomeRepository;
import com.pfa.repo.EtudiantRepository;
import com.pfa.repo.SujetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BinomeServiceImpl implements BinomeService {
    private final BinomeRepository binRepo;
    private final SujetRepository sujetRepo;
    private final EtudiantRepository etuRepo;

    public BinomeServiceImpl(BinomeRepository binRepo, SujetRepository sujetRepo, EtudiantRepository etuRepo) {
        this.binRepo = binRepo;
        this.sujetRepo = sujetRepo;
        this.etuRepo = etuRepo;
    }

    @Override
    public Binome createBinome(BinomeDTO dto) {
        Binome b = new Binome();
        b.setMoyenneTotale(dto.getMoyenneTotale());
        if (dto.getSujetValideId() != null) {
            Sujet s = sujetRepo.findById(dto.getSujetValideId())
                    .orElseThrow(() -> CustomResponseException.BadRequest("Sujet introuvable"));
            b.setSujetValide(s);
        }
        if (dto.getEtudiantIds() != null) {
            List<Etudiant> lst = dto.getEtudiantIds().stream()
                    .map(id -> etuRepo.findById(id)
                            .orElseThrow(() -> CustomResponseException.BadRequest("Etudiant introuvable: " + id)))
                    .collect(Collectors.toList());
            b.setEtudiants(lst);
        }
        return binRepo.save(b);
    }

    @Override
    public Binome getBinomeById(Integer id) {
        return binRepo.findById(id)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Binome non trouvé avec id: " + id));
    }

    @Override
    public List<Binome> getAllBinomes() {
        List<Binome> list = binRepo.findAll();
        if (list.isEmpty()) throw CustomResponseException.ResourceNotFound("Aucun binome trouvé");
        return list;
    }

    @Override
    public Binome updateBinome(Integer id, BinomeDTO dto) {
        Binome b = getBinomeById(id);
        b.setMoyenneTotale(dto.getMoyenneTotale());
        if (dto.getSujetValideId() != null) {
            Sujet s = sujetRepo.findById(dto.getSujetValideId())
                    .orElseThrow(() -> CustomResponseException.BadRequest("Sujet introuvable"));
            b.setSujetValide(s);
        } else b.setSujetValide(null);
        if (dto.getEtudiantIds() != null) {
            List<Etudiant> lst = dto.getEtudiantIds().stream()
                    .map(i -> etuRepo.findById(i)
                            .orElseThrow(() -> CustomResponseException.BadRequest("Etudiant introuvable: " + i)))
                    .collect(Collectors.toList());
            b.setEtudiants(lst);
        } else b.setEtudiants(null);
        return binRepo.save(b);
    }

    @Override
    public void deleteBinome(Integer id) {
        if (!binRepo.existsById(id))
            throw CustomResponseException.ResourceNotFound("Binome non trouvé avec id: " + id);
        binRepo.deleteById(id);
    }
}