package com.example.offerdaysongs.dto;

import com.example.offerdaysongs.model.Recording;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class RuleDto {
    Long id;
    ZonedDateTime startDate;
    ZonedDateTime endDate;
    CompanyDto company;
    Double price;
    List<Recording> recordings;
}
