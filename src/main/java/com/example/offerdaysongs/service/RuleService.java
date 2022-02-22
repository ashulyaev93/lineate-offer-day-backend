package com.example.offerdaysongs.service;

import com.example.offerdaysongs.dto.RuleDto;
import com.example.offerdaysongs.dto.requests.CreateRecordingRequest;
import com.example.offerdaysongs.dto.requests.CreateRuleRequest;
import com.example.offerdaysongs.model.Company;
import com.example.offerdaysongs.model.Recording;
import com.example.offerdaysongs.model.Rule;
import com.example.offerdaysongs.model.Singer;
import com.example.offerdaysongs.repository.CompanyRepository;
import com.example.offerdaysongs.repository.RuleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RuleService {

    private final RuleRepository ruleRepository;
    private final CompanyRepository companyRepository;

    public RuleService(RuleRepository ruleRepository, CompanyRepository companyRepository){
        this.ruleRepository = ruleRepository;
        this.companyRepository = companyRepository;
    }

    public List<Rule> getAll() {
        return ruleRepository.findAll();
    }

    public List<Rule> getAllPeriod() {
        return ruleRepository.findAll();
    }

    public Rule getById(long id) {
        return ruleRepository.findById(id).get();
    }

    public void delete(Long id){
        ruleRepository.deleteById(id);
    }

    @Transactional
    public Rule create(CreateRuleRequest request) {
        Rule rule = new Rule();
        rule.setStartDate(request.getStartDate());
        rule.setEndDate(request.getEndDate());
        var companyDto = request.getCompany();
        if(companyDto != null){
            var company = companyRepository.findById(companyDto.getId()).orElseGet(() -> {
                var temp = new Company();
                temp.setName(companyDto.getName());
                temp.setRules(companyDto.getRules());
                return companyRepository.save(temp);
            });
        rule.setCompany(company);
        }
        rule.setPrice(request.getPrice());
        rule.setRecordings(request.getRecordings());

        return ruleRepository.save(rule);
    }

    @Transactional
    public RuleDto save(RuleDto ruleDto) {//доделать
        Rule rule = new Rule();
        ruleDto.setId(rule.getId());
        ruleDto.setStartDate(rule.getStartDate());
        ruleDto.setEndDate(rule.getEndDate());
        var companyDto = rule.getCompany();
        if(companyDto != null){
            var company = companyRepository.findById(companyDto.getId()).orElseGet(() -> {
                var temp = new Company();
                temp.setName(companyDto.getName());
                temp.setRules(companyDto.getRules());
                return companyRepository.save(temp);
            });
//            ruleDto.setCompany(company);
        }
        ruleDto.setPrice(rule.getPrice());
        ruleDto.setRecordings(rule.getRecordings());

        if (Objects.isNull(ruleDto)) {
            return null;
        } else {
            ruleRepository.save(rule);
        }

        return ruleDto;
    }

    public Optional<RuleDto> update(RuleDto ruleDto) {

        Optional<Rule> optionalRule = ruleRepository.findById(ruleDto.getId());

        if(optionalRule.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(save(ruleDto));
    }
}
