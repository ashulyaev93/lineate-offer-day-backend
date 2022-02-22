package com.example.offerdaysongs.controllers;

import com.example.offerdaysongs.controller.RuleController;;
import com.example.offerdaysongs.repository.CompanyRepository;
import com.example.offerdaysongs.repository.RuleRepository;
import com.example.offerdaysongs.service.CompanyService;
import com.example.offerdaysongs.service.RuleService;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = RuleController.class)
public class RuleControllerTest {

    RuleRepository ruleRepository;
    CompanyRepository companyRepository;
    RuleService ruleService;
    CompanyService companyService;

    @BeforeMethod
    void before(){
        this.ruleRepository = mock(RuleRepository.class);
        this.companyRepository = mock(CompanyRepository.class);
        this.ruleService = new RuleService(ruleRepository,companyRepository);
        this.companyService = new CompanyService(companyRepository);
    }

    @Test
    public void get(){

    }

    @Test
    public void create(){

    }

    @Test
    public void delete(){
        RuleController ruleControllerTest = new RuleController(
                ruleService,
                companyService
        );

        Assert.assertEquals(ruleControllerTest.delete(1L).getStatusCodeValue(), 200);
    }
}
