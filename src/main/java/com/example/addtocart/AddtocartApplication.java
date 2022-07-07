package com.example.addtocart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@SpringBootApplication
@EnableFeignClients
public class AddtocartApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddtocartApplication.class, args);
		System.out.println("SERVER STARTED ----->----->----->----->----->------>------->-------->--------->");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("GET", "POST","PUT", "DELETE");
				;
			}
		};
	}
}
