package com.pfa.dto;

public class EtudiantDTO extends UtilisateurDTO {
    private Float moyenne;
    private Integer sujetId;
    private Integer binomeId;

    public Float getMoyenne() { return moyenne; }
    public void setMoyenne(Float moyenne) { this.moyenne = moyenne; }

    public Integer getSujetId() { return sujetId; }
    public void setSujetId(Integer sujetId) { this.sujetId = sujetId; }

    public Integer getBinomeId() { return binomeId; }
    public void setBinomeId(Integer binomeId) { this.binomeId = binomeId; }
}