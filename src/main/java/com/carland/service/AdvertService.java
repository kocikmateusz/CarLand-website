package com.carland.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.carland.entity.Advert;

public interface AdvertService {

	public void saveAdvert(Advert advert, HttpServletRequest request, MultipartFile[] files);
	
}
