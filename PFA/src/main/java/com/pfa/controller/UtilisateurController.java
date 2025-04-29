package com.pfa.controller;

import com.pfa.Shared.GlobalResponse;
import com.pfa.abstracts.UtilisateurService;
import com.pfa.dto.UtilisateurDTO;
import com.pfa.model.Utilisateur;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping
    public GlobalResponse<Utilisateur> createUtilisateur(@Valid @RequestBody UtilisateurDTO dto) {
        return new GlobalResponse<>(utilisateurService.createUtilisateur(dto));
    }

    @GetMapping("/{id}")
    public GlobalResponse<Utilisateur> getUtilisateur(@PathVariable Integer id) {
        return new GlobalResponse<>(utilisateurService.getUtilisateurById(id));
    }

    @GetMapping
    public GlobalResponse<List<Utilisateur>> getAllUtilisateurs() {
        return new GlobalResponse<>(utilisateurService.getAllUtilisateurs());
    }

    @PutMapping("/{id}")
    public GlobalResponse<Utilisateur> updateUtilisateur(@PathVariable Integer id,
                                                         @Valid @RequestBody UtilisateurDTO dto) {
        return new GlobalResponse<>(utilisateurService.updateUtilisateur(id, dto));
    }

    @DeleteMapping("/{id}")
    public GlobalResponse<String> deleteUtilisateur(@PathVariable Integer id) {
        utilisateurService.deleteUtilisateur(id);
        return new GlobalResponse<>("Utilisateur supprimé avec succès");
    }
}