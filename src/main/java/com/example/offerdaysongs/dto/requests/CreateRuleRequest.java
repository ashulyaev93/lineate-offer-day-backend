package com.example.offerdaysongs.dto.requests;

import com.example.offerdaysongs.model.Company;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class CreateRuleRequest {
    ZonedDateTime startDate;
    ZonedDateTime endDate;
    Company company;
    Double price;
}
