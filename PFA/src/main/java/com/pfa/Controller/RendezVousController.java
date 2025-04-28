package com.pfa.Controller;

import com.pfa.dto.RendezVousDTO;
import com.pfa.Service.RendezVousService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rendezvous")
public class RendezVousController {

    @PostMapping("/{rdvId}/confirmation")
    public ResponseEntity<RendezVousDTO> confirmerRdv(@PathVariable Integer rdvId) {
        return ResponseEntity.ok(RendezVousService.confirmerRdv(rdvId));
    }

    @PostMapping("/{rdvId}/annulation")
    public ResponseEntity<Void> annulerRdv(@PathVariable Integer rdvId) {
        RendezVousService.annulerRdv(rdvId);
        return ResponseEntity.noContent().build();
    }
}
