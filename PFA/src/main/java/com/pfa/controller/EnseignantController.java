package com.pfa.controller;

import com.pfa.Shared.GlobalResponse;
import com.pfa.abstracts.EnseignantService;
import com.pfa.dto.EnseignantDTO;
import com.pfa.model.Enseignant;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {

    private final EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @PostMapping
    public GlobalResponse<Enseignant> createEnseignant(@Valid @RequestBody EnseignantDTO dto) {
        return new GlobalResponse<>(enseignantService.createEnseignant(dto));
    }

    @GetMapping("/{id}")
    public GlobalResponse<Enseignant> getEnseignant(@PathVariable Integer id) {
        return new GlobalResponse<>(enseignantService.getEnseignantById(id));
    }

    @GetMapping
    public GlobalResponse<List<Enseignant>> getAllEnseignants() {
        return new GlobalResponse<>(enseignantService.getAllEnseignants());
    }

    @PutMapping("/{id}")
    public GlobalResponse<Enseignant> updateEnseignant(@PathVariable Integer id,
                                                       @Valid @RequestBody EnseignantDTO dto) {
        return new GlobalResponse<>(enseignantService.updateEnseignant(id, dto));
    }

    @DeleteMapping("/{id}")
    public GlobalResponse<String> deleteEnseignant(@PathVariable Integer id) {
        enseignantService.deleteEnseignant(id);
        return new GlobalResponse<>("Enseignant supprimé avec succès");
    }
}