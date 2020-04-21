package com.carland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	
	
	
	@GetMapping("/profile")
	public String showProfile(Model theModel){
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		System.out.println(username);
		User user = userService.findByUsername(username);
		System.out.println("Street: " + user.getStreet());
		
		System.out.println(user);
		
		theModel.addAttribute("user", user);
		
		return "profile";
	}
	
}
