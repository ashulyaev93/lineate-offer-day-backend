package com.example.offerdaysongs.repository;

import com.example.offerdaysongs.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RuleRepository extends JpaRepository<Rule, Long>, JpaSpecificationExecutor<Rule> {
}
