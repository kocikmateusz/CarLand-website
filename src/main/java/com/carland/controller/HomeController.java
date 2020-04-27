package com.carland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String viewHomePage() {
		return "home";
	}
	
	
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	
	
}
