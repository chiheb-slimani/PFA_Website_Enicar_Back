package com.pfa.service.impl;

import com.pfa.dto.BinomeDTO;
import com.pfa.entity.Binome;
import com.pfa.entity.Etudiant;
import com.pfa.exception.ResourceNotFoundException;
import com.pfa.repository.BinomeRepository;
import com.pfa.repository.EtudiantRepository;
import com.pfa.service.BinomeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BinomeServiceImpl implements BinomeService {

    private final BinomeRepository binomeRepository;
    private final EtudiantRepository etudiantRepository;

    public BinomeServiceImpl(BinomeRepository binomeRepository,
                             EtudiantRepository etudiantRepository) {
        this.binomeRepository = binomeRepository;
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public BinomeDTO createBinome(BinomeDTO dto) {
        Etudiant etudiant1 = etudiantRepository.findById(dto.getEtudiant1Id())
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant 1 non trouvé"));

        Etudiant etudiant2 = etudiantRepository.findById(dto.getEtudiant2Id())
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant 2 non trouvé"));

        Binome binome = new Binome();
        binome.setEtudiant1(etudiant1);
        binome.setEtudiant2(etudiant2);
        return convertToDTO(binomeRepository.save(binome));
    }

    private BinomeDTO convertToDTO(Binome binome) {
        BinomeDTO dto = new BinomeDTO();
        dto.setId(binome.getId());
        dto.setEtudiant1Id(binome.getEtudiant1().getId());
        dto.setEtudiant2Id(binome.getEtudiant2().getId());
        return dto;
    }
}