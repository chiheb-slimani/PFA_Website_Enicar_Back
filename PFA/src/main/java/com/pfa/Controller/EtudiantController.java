package com.pfa.Controller;

import com.pfa.dto.BinomeDTO;
import com.pfa.dto.SujetDTO;
import com.pfa.Service.EtudiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @PostMapping("/{etudiantId}/binomes")
    public ResponseEntity<BinomeDTO> ajouterBinome(
            @PathVariable Integer etudiantId,
            @RequestParam Integer binomeId) {
        return ResponseEntity.ok(EtudiantService.ajouterBinome(etudiantId, binomeId));
    }

    @PatchMapping("/{etudiantId}/sujet")
    public ResponseEntity<SujetDTO> choisirSujet(
            @PathVariable Integer etudiantId,
            @RequestParam Integer sujetId) {
        return ResponseEntity.ok(EtudiantService.choisirSujet(etudiantId, sujetId));
    }
}