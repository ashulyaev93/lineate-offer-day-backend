package com.example.offerdaysongs.dto.requests;

import com.example.offerdaysongs.model.Company;
import com.example.offerdaysongs.model.Recording;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class CreateRuleRequest {
    Long id;
    ZonedDateTime startDate;
    ZonedDateTime endDate;
    Company company;
    Double price;
    List<Recording> recordings;
}
