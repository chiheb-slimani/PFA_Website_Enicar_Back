package com.pfa.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/binomes")
public class BinomeController {

    private BinomeController binomeService;

    @GetMapping("/{binomeId}/moyenne")
    public ResponseEntity<Float> calculerMoyenne(@PathVariable Integer binomeId) {
        return ResponseEntity.ok(binomeService.calculerMoyenne(binomeId).getBody());
    }

    @PostMapping("/{binomeId}/soumission")
    public ResponseEntity<Void> soumettreProjet(
            @PathVariable Integer binomeId,
            @RequestBody MultipartFile projet) {
        binomeService.soumettreProjet(binomeId, projet);
        return ResponseEntity.ok().build();
    }
}