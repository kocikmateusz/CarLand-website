package com.carland.controller;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/sellmycar")
@Controller
public class NewAdvertController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping()
	public String showSellPage(Model theModel) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<String> types = getNamesFromDB("type");
		List<String> makes = getNamesFromDB("make");
		
		theModel.addAttribute("types",types);
		theModel.addAttribute("makes",makes);
		
		return "sellmycar";
	}
	
	@GetMapping("/models")
	public @ResponseBody List<String> findAllModels(
			@RequestParam(value="make", required=true) String make){
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "select name from model where make='" + make + "'";
		
		SQLQuery query = currentSession.createSQLQuery(sql);
	    List<String> models = query.list();
	    
		return models;
	}
	
	public List<String> getNamesFromDB(String table) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "select name from ";
		sql += table;
		
		SQLQuery query = currentSession.createSQLQuery(sql);
	    List<String> types = query.list();
	    
	    return types;
	}
}
