package com.carland.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carland.entity.User;
import com.carland.service.UserService;
import com.carland.user.CrmUser;

@Controller
public class RegistrationController {

	@Autowired
    private UserService userService;
	
	@GetMapping("/registration")
	public String showRegistrationPage(Model theModel) {
		theModel.addAttribute("crmUser", new CrmUser());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registerUser(
			@Valid @ModelAttribute("crmUser") CrmUser theUser,
			BindingResult theBindingResult, 
			Model theModel) {
		
		String username = theUser.getUsername();
		
		if (theBindingResult.hasErrors()){
			 return "registration";
	        }
		
		if(userService.findByUsername(username) != null) {
			theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("registrationError", "User name already exists.");
			return "registration";
		}
		userService.saveUser(theUser);
		
		return "redirect:/";
	}
	
}