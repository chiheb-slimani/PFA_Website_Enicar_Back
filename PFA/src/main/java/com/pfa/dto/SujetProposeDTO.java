package com.pfa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class SujetProposeDTO {
    @NotBlank
    @Size(min = 2, max = 100)
    private String titre;

    @NotBlank
    @Size(min = 10)
    private String description;

    @NotBlank
    private String statut;

    @NotBlank
    private String filiere;

    @NotNull
    private Integer encadrantId;

    @NotNull
    private Date dateProposition;
}