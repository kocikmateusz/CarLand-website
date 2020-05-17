package com.carland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carland.entity.Advert;
import com.carland.service.AdvertService;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	@Autowired
	private AdvertService advertService;
	
	@GetMapping
	public String showManage(Model theModel) {
		
		Advert advert = advertService.getOnePendingAdvert();
		
		theModel.addAttribute("user", advert.getUser());
		theModel.addAttribute("advert",advert);
		
		return "admin";
	}
}
