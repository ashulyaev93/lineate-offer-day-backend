package com.example.offerdaysongs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class RuleDto {
    Long id;
    ZonedDateTime startDate;
    ZonedDateTime endDate;
    CompanyDto company;
    Double price;
    Set<RecordingDto> recordings;
}
