package com.pfa.Controller;

import com.pfa.dto.BinomeDTO;
import com.pfa.dto.RendezVousDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enseignants")
public class EnseignantController {

    private EnseignantController enseignantService;

    @PostMapping("/{enseignantId}/encadrer-binome")
    public ResponseEntity<BinomeDTO> encadrerBinome(
            @PathVariable Integer enseignantId,
            @RequestBody BinomeDTO binomeDTO) {
        return ResponseEntity.ok(enseignantService.encadrerBinome(enseignantId, binomeDTO).getBody());
    }

    @PostMapping("/{enseignantId}/rendezvous")
    public ResponseEntity<RendezVousDTO> planifierRdv(
            @PathVariable Integer enseignantId,
            @RequestBody RendezVousDTO rdvDTO) {
        return ResponseEntity.ok(enseignantService.fixerRdv(enseignantId, rdvDTO));
    }

    private RendezVousDTO fixerRdv(Integer enseignantId, RendezVousDTO rdvDTO) {
        return rdvDTO;
    }
}