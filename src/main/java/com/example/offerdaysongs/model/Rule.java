package com.example.offerdaysongs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @ManyToMany(mappedBy = "rules", fetch = FetchType.EAGER)
    Set<Recording> recordings;
}
