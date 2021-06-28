package com.truyum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.truyum.service.UserService;

@SpringBootApplication
public class TruYumApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(TruYumApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(TruYumApplication.class, args);
		LOGGER.debug("start");
	}

}
