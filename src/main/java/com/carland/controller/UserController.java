package com.carland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.carland.entity.User;
import com.carland.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	public UserController(UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping("/registration")
	public String showRegistrationPage(Model theModel) {
		theModel.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registerUser(@ModelAttribute("user") User theUser) {
		
		userService.saveUser(theUser);
		
		return "redirect:/";
	}
	
	@GetMapping("/profile")
	public String showProfile(Model theModel){
		return "profile";
	}
	
}
