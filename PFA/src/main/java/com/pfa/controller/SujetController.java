package com.pfa.controller;

import com.pfa.Shared.GlobalResponse;
import com.pfa.abstracts.SujetService;
import com.pfa.dto.SujetDTO;
import com.pfa.model.Sujet;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sujets")
public class SujetController {
    private final SujetService sujetService;

    public SujetController(SujetService sujetService) {
        this.sujetService = sujetService;
    }

    @PostMapping
    public GlobalResponse<Sujet> createSujet(@Valid @RequestBody SujetDTO dto) {
        return new GlobalResponse<>(sujetService.createSujet(dto));
    }

    @GetMapping("/{id}")
    public GlobalResponse<Sujet> getSujet(@PathVariable Integer id) {
        return new GlobalResponse<>(sujetService.getSujetById(id));
    }

    @GetMapping
    public GlobalResponse<List<Sujet>> getAllSujets() {
        return new GlobalResponse<>(sujetService.getAllSujets());
    }

    @PutMapping("/{id}")
    public GlobalResponse<Sujet> updateSujet(@PathVariable Integer id,
                                             @Valid @RequestBody SujetDTO dto) {
        return new GlobalResponse<>(sujetService.updateSujet(id, dto));
    }

    @DeleteMapping("/{id}")
    public GlobalResponse<String> deleteSujet(@PathVariable Integer id) {
        sujetService.deleteSujet(id);
        return new GlobalResponse<>("Sujet supprimé avec succès");
    }
}
