package com.carland.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carland.entity.Advert;
import com.carland.entity.User;
import com.carland.service.AdvertService;
import com.carland.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AdvertService advertService;
	
	public UserController(UserService theUserService) {
		userService = theUserService;
	}
	
	
	
	@GetMapping("/profile")
	public String showProfile(Model theModel){
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		User user = userService.findByUsername(username);
		theModel.addAttribute("user", user);
		
		List<Advert> adverts = userService.getUserAdverts(user);
		theModel.addAttribute("adverts",adverts);
		
		return "profile";
	}
	
	@GetMapping("/profile/delete")
	public String deleteAdvert(@RequestParam("advertToDelete") int advertId) {
		advertService.deleteAdvert(advertService.getAdvertById(advertId));
		
		return "redirect:/profile";
	}
	
	
	
	@GetMapping("/logout")  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/";  
     }
	
}
