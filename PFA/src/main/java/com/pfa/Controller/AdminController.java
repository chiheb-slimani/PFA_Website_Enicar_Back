package com.pfa.Controller;

import com.pfa.Service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admins")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @PatchMapping("/{adminId}/valider-sujet/{sujetId}")
    public ResponseEntity validerSujet(
            @PathVariable Integer adminId,
            @PathVariable Integer sujetId) {
        return ResponseEntity.ok(AdminService.validerSujet(adminId, sujetId));
    }
}