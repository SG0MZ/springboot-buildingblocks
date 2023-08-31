package com.stacksimplify.restservices.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stacksimplify.restservices.mappers.UserMapper;

@Configuration
public class AppConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
