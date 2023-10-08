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

import com.app.poseidon.domain.Trade;
import com.app.poseidon.service.TradeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class TradeController {
    // TODO: Inject Trade service
	@Autowired
	private TradeService tradeService;

    @RequestMapping("/trade/list")
    public String home(Model model, HttpServletRequest request)
    {
        // TODO: find all Trade, add to model
    	
    	Principal principal = request.getUserPrincipal();
    	List<Trade> trade = tradeService.getAllTrade();
    	
    	model.addAttribute("trades",trade);
    	model.addAttribute("principal", principal);
    	
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade trade) {
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Trade list
    	 if (result.hasErrors()) {
 	        return "trade/add"; 
 	    }

    	 tradeService.saveTrade(trade);
 	    
 	    return "redirect:/trade/list";
       
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Trade by Id and to model then show to the form
    	Trade trade = tradeService.getTradeById(id);
	    model.addAttribute("trade", trade);
    	
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Trade and return Trade list
    	if (result.hasErrors()) {
            return "trade/update"; 
        }
       
    	tradeService.updateTrade(id, trade);
        
    	
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Trade by Id and delete the Trade, return to Trade list
    	tradeService.deleteTrade(id);
    	
        return "redirect:/trade/list";
    }
}
