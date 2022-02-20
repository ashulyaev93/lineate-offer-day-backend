package com.example.offerdaysongs.service;

import com.example.offerdaysongs.dto.RuleDto;
import com.example.offerdaysongs.dto.requests.CreateRuleRequest;
import com.example.offerdaysongs.model.Rule;
import com.example.offerdaysongs.repository.RuleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RuleService {

    private final RuleRepository ruleRepository;

    public RuleService(RuleRepository ruleRepository){
        this.ruleRepository = ruleRepository;
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
        rule.setCompany(request.getCompany());
        rule.setPrice(request.getPrice());
        rule.setRecordings(request.getRecordings());

        if(Objects.isNull(request)){
            return null;
        }else{
            ruleRepository.save(rule);
        }

        return rule;
    }

    public Optional<Rule> update(CreateRuleRequest request) {

        Optional<Rule> optionalRule = ruleRepository.findById(request.getId());

        if(optionalRule.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(create(request));
    }
}
