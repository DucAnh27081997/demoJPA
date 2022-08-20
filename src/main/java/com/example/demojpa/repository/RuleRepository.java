package com.example.demojpa.repository;

import com.example.demojpa.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends JpaRepository<Rule,Long>, JpaSpecificationExecutor<Rule> {
}
