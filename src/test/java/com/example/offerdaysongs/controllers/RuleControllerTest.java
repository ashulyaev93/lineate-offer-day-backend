package com.example.offerdaysongs.controllers;

import com.example.offerdaysongs.controller.RuleController;
import com.example.offerdaysongs.repository.CompanyRepository;
import com.example.offerdaysongs.repository.RuleRepository;
import com.example.offerdaysongs.service.CompanyService;
import com.example.offerdaysongs.service.RuleService;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;

@SpringBootTest(classes = RuleController.class)
public class RuleControllerTest {

    private static RuleRepository ruleRepository = mock(RuleRepository.class);
    private static CompanyRepository companyRepository = mock(CompanyRepository.class);
    private static RuleService ruleService = new RuleService(ruleRepository,companyRepository);
    private static CompanyService companyService = new CompanyService(companyRepository);

    RuleController ruleController = new RuleController(ruleService, companyService);

    @Test
    public void get(){

    }

    @Test
    public void getAll(){

    }

    @Test
    public void getAllPeriod(){

    }

    @Test
    public void create(){

    }

    @Test
    public void delete(){

        Assert.assertEquals(ruleController.delete(1L).getStatusCodeValue(), 200);

    }
}
