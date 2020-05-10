package com.carland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.carland.entity.Advert;
import com.carland.service.AdvertService;

@Controller
public class HomeController {
	
	@Autowired
	private AdvertService advertService;
	
	@GetMapping("/")
	public String viewHomePage(Model theModel) {
		List<Advert> adverts = advertService.getActiveAdverts();
		
		theModel.addAttribute("adverts", adverts);
		
		return "home";
	}
	
	
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	
	
}
