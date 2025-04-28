package com.pfa.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TacheDTO {
    private Integer id;
    private String titre;
    private String description;
    private LocalDate date;
    private LocalTime temps;
    private Integer binomeId;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getTemps() { return temps; }
    public void setTemps(LocalTime temps) { this.temps = temps; }

    public Integer getBinomeId() { return binomeId; }
    public void setBinomeId(Integer binomeId) { this.binomeId = binomeId; }
}
