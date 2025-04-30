package com.pfa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnseignantDTO {
    @NotBlank
    @Size(min = 2, max = 50)
    private String nom;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6)
    private String motDePasse;

    @NotBlank
    @Size(min = 2, max = 100)
    private String filiere;
}
