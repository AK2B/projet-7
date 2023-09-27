package com.app.poseidon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.poseidon.domain.RuleName;


public interface RuleNameRepository extends JpaRepository<RuleName, Integer> {
}
