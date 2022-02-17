package com.example.offerdaysongs.controller;

import com.example.offerdaysongs.dto.CompanyDto;
import com.example.offerdaysongs.dto.RecordingDto;
import com.example.offerdaysongs.dto.RuleDto;
import com.example.offerdaysongs.dto.SingerDto;
import com.example.offerdaysongs.model.Recording;
import com.example.offerdaysongs.model.Rule;
import com.example.offerdaysongs.service.RecordingService;
import com.example.offerdaysongs.service.RuleService;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rule")
public class RuleController {
    private static final String ID = "id";
    private final RuleService ruleService;

    public RuleController(RuleService ruleService){
        this.ruleService = ruleService;
    }

    @GetMapping("/{id:[\\d]+}")
    public RuleDto get(@PathVariable(ID) long id) {
        var rule = ruleService.getById(id);
        return convertToDto(rule);
    }

    @GetMapping("/")
    public List<RuleDto> getAll() {
        var rules = ruleService.getAll();
        return rules.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

//    @GetMapping("/")?startDate&endDate
//    @GetMapping("/")?companies
//    @GetMapping("/price")?recording

//    @PostMapping("/")
//    @PutMapping("/")
//    @DeleteMapping("/")

    private RuleDto convertToDto(Rule rule)
    {
        Recording recordingEntity = new Recording();
        var singer = recordingEntity.getSinger();
        RecordingDto recordingDto = new RecordingDto(recordingEntity.getId(),
                recordingEntity.getTitle(),
                recordingEntity.getVersion(),
                recordingEntity.getReleaseTime(),
                singer != null ? new SingerDto(singer.getId(), singer.getName()) : null);

        var company = rule.getCompany();
        var recording = rule.getRecordings();

        Set<RecordingDto> recordingDtoSet = new HashSet<RecordingDto>();
        recordingDtoSet.add(recordingDto);

        return new RuleDto(
                rule.getId(),
                rule.getStartDate(),
                rule.getEndDate(),
                company != null ? new CompanyDto(company.getId(), company.getName()) : null,
                rule.getPrice(),
                recording != null ? recordingDtoSet : null);
    }
}
