package com.carland;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.carland.service.StorageService;


@SpringBootApplication
public class CarlandApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarlandApplication.class, args);
	}
	
	

}


