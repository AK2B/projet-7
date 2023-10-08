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

import com.app.poseidon.domain.CurvePoint;
import com.app.poseidon.service.CurvePointService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;


@Controller
public class CurveController {
    // TODO: Inject Curve Point service
	@Autowired
	private CurvePointService curvePointService;
	
    @RequestMapping("/curvePoint/list")
    public String home(Model model, HttpServletRequest request)  {
    	
        // TODO: find all Curve Point, add to model
    	
    	Principal principal = request.getUserPrincipal();
    	List<CurvePoint> curvePoint = curvePointService.getAllCurvePoint();
    	
    	model.addAttribute("curvePoints",curvePoint);
    	model.addAttribute("principal", principal);
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint curve) {
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curve, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Curve list
    	if (result.hasErrors()) {
	        return "curvePoint/add"; 
	    }

    	curvePointService.savecurvePoint(curve);
    	
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get CurvePoint by Id and to model then show to the form
    	CurvePoint curvePoint = curvePointService.getCurvePointById(id);
	    model.addAttribute("curvePoint", curvePoint);
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Curve and return Curve list
    	if (result.hasErrors()) {
            return "curvePoint/update"; 
        }
       
    	curvePointService.updatecurvePoint(id, curvePoint);
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Curve by Id and delete the Curve, return to Curve list
    	curvePointService.deleteCurvePoint(id);
        return "redirect:/curvePoint/list";
    }
}
