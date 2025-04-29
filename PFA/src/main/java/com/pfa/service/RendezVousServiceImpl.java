package com.pfa.service;


import com.pfa.Shared.CustomResponseException;
import com.pfa.abstracts.RendezVousService;
import com.pfa.dto.RendezVousDTO;
import com.pfa.model.Binome;
import com.pfa.model.RendezVous;
import com.pfa.repo.BinomeRepository;
import com.pfa.repo.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousServiceImpl implements RendezVousService {
    private final RendezVousRepository rdvRepo;
    private final BinomeRepository binomeRepo;

    public RendezVousServiceImpl(RendezVousRepository rdvRepo, BinomeRepository binomeRepo) {
        this.rdvRepo = rdvRepo;
        this.binomeRepo = binomeRepo;
    }

    @Override
    public RendezVous createRendezVous(RendezVousDTO dto) {
        RendezVous rdv = new RendezVous();
        rdv.setDate(dto.getDate());
        rdv.setHeure(dto.getHeure());
        rdv.setDescription(dto.getDescription());
        Binome b = binomeRepo.findById(dto.getBinomeId())
                .orElseThrow(() -> CustomResponseException.BadRequest("Binome introuvable"));
        rdv.setBinome(b);
        return rdvRepo.save(rdv);
    }

    @Override
    public RendezVous getRendezVousById(Integer id) {
        return rdvRepo.findById(id)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("RendezVous non trouvé avec id: " + id));
    }

    @Override
    public List<RendezVous> getAllRendezVous() {
        List<RendezVous> list = rdvRepo.findAll();
        if (list.isEmpty()) {
            throw CustomResponseException.ResourceNotFound("Aucun rendez-vous trouvé");
        }
        return list;
    }

    @Override
    public RendezVous updateRendezVous(Integer id, RendezVousDTO dto) {
        RendezVous rdv = getRendezVousById(id);
        rdv.setDate(dto.getDate());
        rdv.setHeure(dto.getHeure());
        rdv.setDescription(dto.getDescription());
        Binome b = binomeRepo.findById(dto.getBinomeId())
                .orElseThrow(() -> CustomResponseException.BadRequest("Binome introuvable"));
        rdv.setBinome(b);
        return rdvRepo.save(rdv);
    }

    @Override
    public void deleteRendezVous(Integer id) {
        if (!rdvRepo.existsById(id)) {
            throw CustomResponseException.ResourceNotFound("RendezVous non trouvé avec id: " + id);
        }
        rdvRepo.deleteById(id);
    }
}
