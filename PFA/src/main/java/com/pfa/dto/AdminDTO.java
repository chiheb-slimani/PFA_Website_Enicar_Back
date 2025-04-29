package com.pfa.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AdminDTO {
     @NotNull  @Min(10000000) @Max(99999999)
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