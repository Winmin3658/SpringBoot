package com.kh.mallapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class MallapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallapiApplication.class, args);
	}

}
