package com.pfa.abstracts;

import com.pfa.dto.TacheDTO;
import com.pfa.model.Tache;

import java.util.List;

public interface TacheService {
    Tache createTache(TacheDTO dto);

    Tache getTacheById(Integer id);

    List<Tache> getAllTaches();

    Tache updateTache(Integer id, TacheDTO dto);

    void deleteTache(Integer id);
}
