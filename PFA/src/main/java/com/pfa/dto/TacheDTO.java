package com.pfa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class TacheDTO {
    @NotBlank
    @Size(min = 2, max = 100)
    private String titre;

    @NotBlank
    @Size(min = 5)
    private String description;

    @NotNull
    private Date date;

    @NotNull
    private Date temps;
}
