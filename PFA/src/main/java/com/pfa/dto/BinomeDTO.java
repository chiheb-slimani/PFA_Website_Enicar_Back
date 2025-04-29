package com.pfa.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class BinomeDTO {
    @NotNull
    private Float moyenneTotale;
    private Integer sujetValideId;
    private List<Integer> etudiantIds;
}