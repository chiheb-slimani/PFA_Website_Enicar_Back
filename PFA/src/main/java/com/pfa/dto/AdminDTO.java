package com.pfa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminDTO {
     @NotBlank @Size(min=8, max=8)
    private int numero;

    @NotBlank
    @Size(min=2,max=50)
    private String nom;

    @NotBlank
    @Size(min=2,max=50)
    private String prenom;


    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min=6)
    private String motDePasse;
}