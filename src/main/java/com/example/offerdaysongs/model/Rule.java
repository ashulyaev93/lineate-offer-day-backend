package com.example.offerdaysongs.model;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Data
@Entity
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    ZonedDateTime startDate;
    ZonedDateTime endDate;
    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    Company company;
    Double price;
    @ManyToMany(mappedBy = "rules")
    Set<Recording> recordings;
}
