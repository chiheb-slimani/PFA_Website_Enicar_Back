package com.pfa.controller;

import com.pfa.Shared.GlobalResponse;
import com.pfa.abstracts.TacheService;
import com.pfa.dto.TacheDTO;
import com.pfa.model.Tache;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taches")
public class TacheController {
    private final TacheService tacheService;

    public TacheController(TacheService tacheService) {
        this.tacheService = tacheService;
    }

    @PostMapping
    public GlobalResponse<Tache> createTache(@Valid @RequestBody TacheDTO dto) {
        return new GlobalResponse<>(tacheService.createTache(dto));
    }

    @GetMapping("/{id}")
    public GlobalResponse<Tache> getTache(@PathVariable Integer id) {
        return new GlobalResponse<>(tacheService.getTacheById(id));
    }

    @GetMapping
    public GlobalResponse<List<Tache>> getAllTaches() {
        return new GlobalResponse<>(tacheService.getAllTaches());
    }

    @PutMapping("/{id}")
    public GlobalResponse<Tache> updateTache(@PathVariable Integer id,
                                             @Valid @RequestBody TacheDTO dto) {
        return new GlobalResponse<>(tacheService.updateTache(id, dto));
    }

    @DeleteMapping("/{id}")
    public GlobalResponse<String> deleteTache(@PathVariable Integer id) {
        tacheService.deleteTache(id);
        return new GlobalResponse<>("Tâche supprimée avec succès");
    }
}
