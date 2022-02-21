package com.example.offerdaysongs.dto.requests;

import com.example.offerdaysongs.model.Rule;
import lombok.Data;

import java.util.Set;

@Data
public class CreateSingerRequest {
    private String name;
    private Set<Rule> rules;
}
