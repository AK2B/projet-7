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

import com.app.poseidon.domain.Rating;
import com.app.poseidon.service.RatingService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class RatingController {
	
    // TODO: Inject Rating service
	@Autowired
	private RatingService ratingService;
	
    @RequestMapping("/rating/list")
    public String home(Model model, HttpServletRequest request)
    {
        // TODO: find all Rating, add to model
    	
    	Principal principal = request.getUserPrincipal();
    	List<Rating> rating = ratingService.getAllRating();
    	
    	model.addAttribute("ratings",rating);
    	model.addAttribute("principal", principal);
    	
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list
    	if (result.hasErrors()) {
	        return "rating/add"; 
	    }

    	ratingService.saveRating(rating);
	    
	    return "redirect:/rating/list";
        
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Rating by Id and to model then show to the form
    	Rating rating = ratingService.getRatingById(id);
	    model.addAttribute("rating", rating);
    	
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Rating and return Rating list
    	if (result.hasErrors()) {
            return "rating/update"; 
        }
       
    	ratingService.updateRating(id, rating);
        
    	
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Rating by Id and delete the Rating, return to Rating list
    	ratingService.deleteRating(id);
    	
        return "redirect:/rating/list";
    }
}
