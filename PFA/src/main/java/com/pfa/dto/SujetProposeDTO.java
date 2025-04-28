package com.pfa.dto;

import java.util.Date;

public class SujetProposeDTO extends SujetDTO {
    private Date dateProposition;

    public Date getDateProposition() { return dateProposition; }
    public void setDateProposition(Date dateProposition) { this.dateProposition = dateProposition; }
}