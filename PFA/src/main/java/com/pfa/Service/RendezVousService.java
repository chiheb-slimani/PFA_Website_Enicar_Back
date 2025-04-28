package com.pfa.Service;

import com.pfa.dto.RendezVousDTO;

public interface RendezVousService {
    static void annulerRdv(Integer rdvId) {
    }

    static RendezVousDTO confirmerRdv(Integer rdvId) {
        return null;
    }

    RendezVousDTO planifierRendezVous(RendezVousDTO rdvDTO);
    void confirmerRendezVous(Integer rdvId);
    void annulerRendezVous(Integer rdvId);
}