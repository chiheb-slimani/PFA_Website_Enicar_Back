package com.pfa.Controller;

import com.pfa.dto.TacheDTO;
import com.pfa.Service.TacheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

    @PatchMapping("/{tacheId}/date")
    public ResponseEntity<TacheDTO> modifierDate(
            @PathVariable Integer tacheId,
            @RequestBody LocalDate nouvelleDate) {
        return ResponseEntity.ok(TacheService.modifierDate(tacheId, nouvelleDate));
    }
}