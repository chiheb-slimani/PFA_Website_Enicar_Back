package com.pfa.Service;

import com.pfa.dto.BinomeDTO;
import com.pfa.dto.TacheDTO;
import org.springframework.web.multipart.MultipartFile;

public interface BinomeService {
    BinomeDTO creerBinome(BinomeDTO binomeDTO);
    Double calculerMoyenne(Integer binomeId);
    void soumettreProjet(Integer binomeId, MultipartFile fichier);
    TacheDTO ajouterTache(Integer binomeId, TacheDTO tacheDTO);
}