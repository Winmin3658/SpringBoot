package com.kh.image_shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.kh.image_shop.mapper")
public class ImageShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageShopApplication.class, args);
	}

}
