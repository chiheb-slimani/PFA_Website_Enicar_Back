package com.pfa.dto;

public class SujetDTO {
    private Integer id;
    private String titre;
    private String description;
    private String statut;
    private String nombreComplementaire;
    private String filiere;
    private Integer encadrantId;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public String getNombreComplementaire() { return nombreComplementaire; }
    public void setNombreComplementaire(String nombreComplementaire) { this.nombreComplementaire = nombreComplementaire; }

    public String getFiliere() { return filiere; }
    public void setFiliere(String filiere) { this.filiere = filiere; }

    public Integer getEncadrantId() { return encadrantId; }
    public void setEncadrantId(Integer encadrantId) { this.encadrantId = encadrantId; }
}