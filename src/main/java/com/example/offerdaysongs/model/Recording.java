package com.example.offerdaysongs.model;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Data
@Entity
public class Recording {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String version;
    ZonedDateTime releaseTime;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Singer singer;
    @ManyToMany
    @JoinTable(name = "rule_recording", joinColumns = @JoinColumn(name = "recording_id"), inverseJoinColumns = @JoinColumn(name = "rule_id"))
    Set<Rule> rules;
}
