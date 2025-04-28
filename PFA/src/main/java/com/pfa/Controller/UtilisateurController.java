package com.pfa.Controller;

import com.pfa.Service.UtilisateurService;
import com.pfa.dto.SujetDTO;
import com.pfa.dto.SujetProposeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController() {
        this(null);
    }

    public UtilisateurController(UtilisateurService UtilisateurService) {
        this.utilisateurService = UtilisateurService;
    }

    @PostMapping("/{userId}/proposer-sujet")
    public ResponseEntity<SujetDTO> proposerSujet(
            @PathVariable Integer userId,
            @RequestBody SujetProposeDTO sujetDTO) {
        return ResponseEntity.ok(utilisateurService.proposerSujet(userId, sujetDTO));
    }
}
