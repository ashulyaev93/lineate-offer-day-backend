package com.example.offerdaysongs.controller;

import com.example.offerdaysongs.dto.CompanyDto;
import com.example.offerdaysongs.dto.RuleDto;
import com.example.offerdaysongs.dto.requests.CreateRuleRequest;
import com.example.offerdaysongs.model.Rule;
import com.example.offerdaysongs.service.RuleService;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rule")
public class RuleController {

    private final RuleService ruleService;

    public RuleController(RuleService ruleService){
        this.ruleService = ruleService;
    }

    @GetMapping("/{id}")
    public RuleDto get(@PathVariable Long id) {
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

    @GetMapping("/period")
    public List<RuleDto> getAllPeriod(@RequestParam(value = "startDate") String startDate,
                                      @RequestParam(value = "endDate") String endDate){
        var rules = ruleService.getAllPeriod();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate date1 = LocalDate.parse(startDate, dtf);
        LocalDate date2 = LocalDate.parse(endDate, dtf);

        ZonedDateTime localDateTimeStart = date1.atStartOfDay(ZoneId.systemDefault());
        ZonedDateTime localDateTimeEnd = date2.atStartOfDay(ZoneId.systemDefault());

        return rules.stream()
                .filter(s -> s.getStartDate().isAfter(localDateTimeStart))
                .filter(e -> e.getEndDate().isBefore(localDateTimeEnd))
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public RuleDto create(@RequestBody CreateRuleRequest request) {
        return convertToDto(ruleService.create(request));
    }

    @PutMapping("/")
    public ResponseEntity<Rule> update(@RequestBody CreateRuleRequest request) {

        Optional<Rule> optional = ruleService.update(request);

        if(optional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(optional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        try{
            ruleService.delete(id);
        }catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("Rule with id = " + id + " deleted!");
    }

    private RuleDto convertToDto(Rule rule)
    {
        var company = rule.getCompany();

        return new RuleDto(
                rule.getId(),
                rule.getStartDate(),
                rule.getEndDate(),
                company != null ? new CompanyDto(company.getId(), company.getName()) : null,
                rule.getPrice(),
                rule.getRecordings());
    }
}
