package com.example.offerdaysongs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

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
    @JsonIgnore
    @ManyToMany(mappedBy = "rule")
    List<Recording> recordings;
}
