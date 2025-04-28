package com.pfa.Service;

import com.pfa.dto.TacheDTO;
import java.time.LocalDate;

public interface TacheService {
    static TacheDTO modifierDate(Integer tacheId, LocalDate nouvelleDate) {
        return null;
    }

    TacheDTO creerTache(TacheDTO tacheDTO);
    TacheDTO modifierDateTache(Integer tacheId, LocalDate nouvelleDate);
    void supprimerTache(Integer tacheId);
}