package com.app.poseidon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.poseidon.domain.RuleName;
import com.app.poseidon.repositories.RuleNameRepository;

import jakarta.validation.Valid;

@Service
public class RuleNameService {

	@Autowired
	private RuleNameRepository ruleNameRepository;
	
	public List<RuleName> getAllRuleName () {
		return ruleNameRepository.findAll();
	}

	public RuleName saveRuleName(@Valid RuleName ruleName) {
		return ruleNameRepository.save(ruleName);
		
	}

	public RuleName getRuleNameById(Integer id) {
		return ruleNameRepository.getById(id);
	}

	public RuleName updateRuleName(Integer id, @Valid RuleName ruleName) {
		return ruleNameRepository.save(ruleName);
		
	}

	public void deleteRuleName(Integer id) {
		ruleNameRepository.deleteById(id);
		
	}

	
}
