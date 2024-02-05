package com.manojskillhub;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NewTaskProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewTaskProjectApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}

}
