package com.pfa.abstracts;

import com.pfa.dto.RendezVousDTO;
import com.pfa.model.RendezVous;

import java.util.List;

public interface RendezVousService {
    RendezVous createRendezVous(RendezVousDTO dto);

    RendezVous getRendezVousById(Integer id);

    List<RendezVous> getAllRendezVous();

    RendezVous updateRendezVous(Integer id, RendezVousDTO dto);

    void deleteRendezVous(Integer id);
}
