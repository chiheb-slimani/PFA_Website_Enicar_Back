package com.pfa.dto;

import java.util.List;

public class BinomeDTO {
    private Integer id;
    private Float moyenneTotale;
    private Integer sujetValideId;
    private List<Integer> etudiantIds;
    private List<Integer> sujetsProposesIds;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Float getMoyenneTotale() { return moyenneTotale; }
    public void setMoyenneTotale(Float moyenneTotale) { this.moyenneTotale = moyenneTotale; }

    public Integer getSujetValideId() { return sujetValideId; }
    public void setSujetValideId(Integer sujetValideId) { this.sujetValideId = sujetValideId; }

    public List<Integer> getEtudiantIds() { return etudiantIds; }
    public void setEtudiantIds(List<Integer> etudiantIds) { this.etudiantIds = etudiantIds; }

    public List<Integer> getSujetsProposesIds() { return sujetsProposesIds; }
    public void setSujetsProposesIds(List<Integer> sujetsProposesIds) { this.sujetsProposesIds = sujetsProposesIds; }
}
