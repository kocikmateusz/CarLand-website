package com.carland.controller;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.carland.entity.Advert;
import com.carland.service.AdvertService;
import com.carland.service.StorageService;

@RequestMapping("/sellmycar")
@Controller
public class NewAdvertController {

	@Autowired
	private AdvertService advertService;
	
	@Autowired
	private StorageService storageService;
	
	
	@Autowired
	private EntityManager entityManager;

	
	@GetMapping()
	public String showSellPage(Model theModel) throws IOException {
		
		List<String> types = getNamesFromDB("type");
		List<String> makes = getNamesFromDB("make");
		
		theModel.addAttribute("types",types);
		theModel.addAttribute("makes",makes);
		
		Advert advert = new Advert();
		theModel.addAttribute("advert",advert);
		
		
		
		return "sellmycar";
	}
	
	@PostMapping()
	public String saveAdvert(
			@Valid @ModelAttribute("advert") Advert advert,
			@RequestParam("file") MultipartFile[] files,
			BindingResult theBindingResult, 
			HttpServletRequest request,
			Model theModel) {
		
		
		advertService.saveAdvert(advert, request,files);
		
		storageService.store(files);
		
		return "home";
	}
	
	
	
	
	@GetMapping("/models")
	public @ResponseBody List<String> findAllModels(
			@RequestParam(value="make", required=true) String make){
		Session currentSession = entityManager.unwrap(Session.class);
		
		String sql = "select name from model where make='" + make + "'";
		
		SQLQuery query = currentSession.createSQLQuery(sql);
	    List<String> models = query.list();
	    
		return models;
	}
	
	public List<String> getNamesFromDB(String table) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		String sql = "select name from ";
		sql += table;
		
		SQLQuery query = currentSession.createSQLQuery(sql);
	    List<String> types = query.list();
	    
	    return types;
	}
}
