package com.carland.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		User user = userService.findByUsername(username);
		
		theModel.addAttribute("user", user);
		
		return "profile";
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
