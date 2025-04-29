package com.pfa.controller;

import com.pfa.Shared.GlobalResponse;
import com.pfa.abstracts.EtudiantService;
import com.pfa.dto.EtudiantDTO;
import com.pfa.model.Etudiant;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    private final EtudiantService etuService;

    public EtudiantController(EtudiantService etuService) {
        this.etuService = etuService;
    }

    @PostMapping
    public GlobalResponse<Etudiant> createEtudiant(@Valid @RequestBody EtudiantDTO dto) {
        return new GlobalResponse<>(etuService.createEtudiant(dto));
    }

    @GetMapping("/{id}")
    public GlobalResponse<Etudiant> getEtudiant(@PathVariable Integer id) {
        return new GlobalResponse<>(etuService.getEtudiantById(id));
    }

    @GetMapping
    public GlobalResponse<List<Etudiant>> getAllEtudiants() {
        return new GlobalResponse<>(etuService.getAllEtudiants());
    }

    @PutMapping("/{id}")
    public GlobalResponse<Etudiant> updateEtudiant(@PathVariable Integer id, @Valid @RequestBody EtudiantDTO dto) {
        return new GlobalResponse<>(etuService.updateEtudiant(id, dto));
    }

    @DeleteMapping("/{id}")
    public GlobalResponse<String> deleteEtudiant(@PathVariable Integer id) {
        etuService.deleteEtudiant(id);
        return new GlobalResponse<>("Etudiant supprimé avec succès");
    }
}
