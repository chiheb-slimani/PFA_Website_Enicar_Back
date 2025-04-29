package com.pfa.controller;


import com.pfa.Shared.GlobalResponse;
import com.pfa.abstracts.SujetProposeService;
import com.pfa.dto.SujetProposeDTO;
import com.pfa.model.SujetPropose;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sujets-proposes")
public class SujetProposeController {
    private final SujetProposeService service;

    public SujetProposeController(SujetProposeService service) {
        this.service = service;
    }

    @PostMapping
    public GlobalResponse<SujetPropose> createSujetPropose(@Valid @RequestBody SujetProposeDTO dto) {
        return new GlobalResponse<>(service.createSujetPropose(dto));
    }

    @GetMapping("/{id}")
    public GlobalResponse<SujetPropose> getSujetPropose(@PathVariable Integer id) {
        return new GlobalResponse<>(service.getSujetProposeById(id));
    }

    @GetMapping
    public GlobalResponse<List<SujetPropose>> getAllSujetsProposes() {
        return new GlobalResponse<>(service.getAllSujetsProposes());
    }

    @PutMapping("/{id}")
    public GlobalResponse<SujetPropose> updateSujetPropose(@PathVariable Integer id,
                                                           @Valid @RequestBody SujetProposeDTO dto) {
        return new GlobalResponse<>(service.updateSujetPropose(id, dto));
    }

    @DeleteMapping("/{id}")
    public GlobalResponse<String> deleteSujetPropose(@PathVariable Integer id) {
        service.deleteSujetPropose(id);
        return new GlobalResponse<>("Sujet proposé supprimé avec succès");
    }
}
