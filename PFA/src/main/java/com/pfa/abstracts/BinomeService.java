package com.pfa.abstracts;

import com.pfa.dto.BinomeDTO;
import com.pfa.model.Binome;

import java.util.List;

public interface BinomeService {
    Binome createBinome(BinomeDTO dto);

    Binome getBinomeById(Integer id);

    List<Binome> getAllBinomes();

    Binome updateBinome(Integer id, BinomeDTO dto);

    void deleteBinome(Integer id);
}