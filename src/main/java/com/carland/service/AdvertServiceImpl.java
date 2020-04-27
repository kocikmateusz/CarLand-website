package com.carland.service;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carland.dao.AdvertDao;
import com.carland.entity.Advert;
import com.carland.entity.User;

@Service
public class AdvertServiceImpl implements AdvertService {
	
	@Autowired
	AdvertDao advertDao;
	

	@Override
	public void saveAdvert(Advert advert, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		User theUser = (User)session.getAttribute("user");
		
		advert.setUser(theUser);
		advert.setExpirationDate(LocalDate.now().plusDays(14));
		
		advertDao.saveAdvert(advert);

	}

}
