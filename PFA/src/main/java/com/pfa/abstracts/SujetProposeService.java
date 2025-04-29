package com.pfa.abstracts;

import com.pfa.dto.SujetProposeDTO;
import com.pfa.model.SujetPropose;

import java.util.List;

public interface SujetProposeService {
    SujetPropose createSujetPropose(SujetProposeDTO dto);

    SujetPropose getSujetProposeById(Integer id);

    List<SujetPropose> getAllSujetsProposes();

    SujetPropose updateSujetPropose(Integer id, SujetProposeDTO dto);

    void deleteSujetPropose(Integer id);
}