package com.carland.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.carland.entity.Advert;

public interface AdvertService {

	public void saveAdvert(Advert advert, HttpServletRequest request, MultipartFile[] files);

	public Advert getAdvertById(int id);
	
	
	public List<Advert> getActiveAdverts();
}
