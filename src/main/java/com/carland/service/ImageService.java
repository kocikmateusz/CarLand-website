package com.carland.service;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.carland.entity.Advert;
import com.carland.entity.Image;

public interface ImageService {
	public void save(Image image);

	public void save(MultipartFile[] files,  Advert advert);
}
