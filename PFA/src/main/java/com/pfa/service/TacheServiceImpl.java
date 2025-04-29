package com.pfa.service;

import com.pfa.Shared.CustomResponseException;
import com.pfa.abstracts.TacheService;
import com.pfa.dto.TacheDTO;
import com.pfa.model.Tache;
import com.pfa.repo.TacheRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheServiceImpl implements TacheService {
    private final TacheRepository tacheRepo;

    public TacheServiceImpl(TacheRepository tacheRepo) {
        this.tacheRepo = tacheRepo;
    }

    @Override
    public Tache createTache(TacheDTO dto) {
        Tache t = new Tache();
        t.setTitre(dto.getTitre());
        t.setDescription(dto.getDescription());
        t.setDate(dto.getDate());
        t.setTemps(dto.getTemps());
        return tacheRepo.save(t);
    }

    @Override
    public Tache getTacheById(Integer id) {
        return tacheRepo.findById(id)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Tâche non trouvée avec id: " + id));
    }

    @Override
    public List<Tache> getAllTaches() {
        List<Tache> list = tacheRepo.findAll();
        if (list.isEmpty()) {
            throw CustomResponseException.ResourceNotFound("Aucune tâche trouvée");
        }
        return list;
    }

    @Override
    public Tache updateTache(Integer id, TacheDTO dto) {
        Tache t = getTacheById(id);
        t.setTitre(dto.getTitre());
        t.setDescription(dto.getDescription());
        t.setDate(dto.getDate());
        t.setTemps(dto.getTemps());
        return tacheRepo.save(t);
    }

    @Override
    public void deleteTache(Integer id) {
        if (!tacheRepo.existsById(id)) {
            throw CustomResponseException.ResourceNotFound("Tâche non trouvée avec id: " + id);
        }
        tacheRepo.deleteById(id);
    }
}