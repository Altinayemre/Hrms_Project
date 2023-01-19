package com.emre.hrmsProject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;



//@Configuration
public class ModelMapping {
	
	@Bean
	private ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
