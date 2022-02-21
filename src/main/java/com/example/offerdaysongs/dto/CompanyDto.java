package com.example.offerdaysongs.dto;

import com.example.offerdaysongs.model.Rule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class CompanyDto {
    Long id;
    String name;
    Set<Rule> rules;
}
