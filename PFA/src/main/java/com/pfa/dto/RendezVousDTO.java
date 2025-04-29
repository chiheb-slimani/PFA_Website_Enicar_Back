package com.pfa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class RendezVousDTO {
    @NotNull
    private Date date;

    @NotNull
    private Date heure;

    @NotBlank
    private String description;

    @NotNull
    private Integer binomeId;
}