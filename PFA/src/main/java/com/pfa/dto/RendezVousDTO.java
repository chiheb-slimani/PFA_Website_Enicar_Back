package com.pfa.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class RendezVousDTO {
    private Integer id;
    private LocalDate date;
    private LocalTime heure;
    private String description;
    private Integer binomeId;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getHeure() { return heure; }
    public void setHeure(LocalTime heure) { this.heure = heure; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getBinomeId() { return binomeId; }
    public void setBinomeId(Integer binomeId) { this.binomeId = binomeId; }
}