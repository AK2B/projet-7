package com.app.poseidon.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.poseidon.domain.RuleName;
import com.app.poseidon.service.RuleNameService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class RuleNameController {
    // TODO: Inject RuleName service
	@Autowired
	private RuleNameService ruleNameService;
	
    @RequestMapping("/ruleName/list")
    public String home(Model model, HttpServletRequest request)
    {
        // TODO: find all RuleName, add to model
    	
    	Principal principal = request.getUserPrincipal();
    	List<RuleName> ruleName = ruleNameService.getAllRuleName();
    	
    	model.addAttribute("ruleNames",ruleName);
    	model.addAttribute("principal", principal);
    	
      
    	
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName ruleName) {
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
    	
        // TODO: check data valid and save to db, after saving return RuleName list
    	 if (result.hasErrors()) {
 	        return "ruleName/add"; 
 	    }

    	 ruleNameService.saveRuleName(ruleName);
 	    
 	   return "redirect:/ruleName/list";
        
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	
        // TODO: get RuleName by Id and to model then show to the form
    	RuleName ruleName = ruleNameService.getRuleNameById(id);
 	    model.addAttribute("ruleName", ruleName);
    	
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
    	
        // TODO: check required fields, if valid call service to update RuleName and return RuleName list
    	if (result.hasErrors()) {
            return "ruleName/update"; 
        }
       
    	ruleNameService.updateRuleName(id, ruleName);
        
        
    	
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        // TODO: Find RuleName by Id and delete the RuleName, return to Rule list
    	ruleNameService.deleteRuleName(id);
    	 
        return "redirect:/ruleName/list";
    }
}
