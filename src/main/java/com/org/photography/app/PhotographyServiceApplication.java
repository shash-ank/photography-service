package com.org.photography.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class PhotographyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.org.photography.app.PhotographyServiceApplication.class, args);

	}
	@PostConstruct
	public void init()
	{
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
	}

}
