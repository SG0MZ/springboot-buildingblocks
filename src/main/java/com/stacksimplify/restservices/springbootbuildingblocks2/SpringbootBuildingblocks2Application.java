package com.stacksimplify.restservices.springbootbuildingblocks2;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

//Second Commit
@SpringBootApplication
@ComponentScan(basePackages = {"com.stacksimplify.restservices.Hello"
		,"com.stacksimplify.restservices.repositories"
		,"com.stacksimplify.restservices.controllers"
		,"com.stacksimplify.restservices.services"
		,"com.stacksimplify.restservices.exceptions"
		,"com.stacksimplify.restservices.dtos"
		,"com.stacksimplify.restservices.config"})
@EntityScan("com.stacksimplify.restservices.entities")
@EnableJpaRepositories("com.stacksimplify.restservices.repositories")
public class SpringbootBuildingblocks2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBuildingblocks2Application.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
}
