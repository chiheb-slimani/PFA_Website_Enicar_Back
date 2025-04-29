package com.pfa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "sujet_propose")
@PrimaryKeyJoinColumn(name = "id")
@Data
public class SujetPropose extends Sujet {
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateProposition;
}
