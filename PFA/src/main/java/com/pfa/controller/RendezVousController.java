package com.pfa.controller;

import com.pfa.Shared.GlobalResponse;
import com.pfa.abstracts.RendezVousService;
import com.pfa.dto.RendezVousDTO;
import com.pfa.model.RendezVous;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendezvous")
public class RendezVousController {
    private final RendezVousService rdvService;

    public RendezVousController(RendezVousService rdvService) {
        this.rdvService = rdvService;
    }

    @PostMapping
    public GlobalResponse<RendezVous> createRendezVous(@Valid @RequestBody RendezVousDTO dto) {
        return new GlobalResponse<>(rdvService.createRendezVous(dto));
    }

    @GetMapping("/{id}")
    public GlobalResponse<RendezVous> getRendezVous(@PathVariable Integer id) {
        return new GlobalResponse<>(rdvService.getRendezVousById(id));
    }

    @GetMapping
    public GlobalResponse<List<RendezVous>> getAllRendezVous() {
        return new GlobalResponse<>(rdvService.getAllRendezVous());
    }

    @PutMapping("/{id}")
    public GlobalResponse<RendezVous> updateRendezVous(@PathVariable Integer id,
                                                       @Valid @RequestBody RendezVousDTO dto) {
        return new GlobalResponse<>(rdvService.updateRendezVous(id, dto));
    }

    @DeleteMapping("/{id}")
    public GlobalResponse<String> deleteRendezVous(@PathVariable Integer id) {
        rdvService.deleteRendezVous(id);
        return new GlobalResponse<>("RendezVous supprimé avec succès");
    }
}
