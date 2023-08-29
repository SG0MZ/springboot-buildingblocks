package com.stacksimplify.restservices.springbootbuildingblocks2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//Second Commit
@SpringBootApplication
@ComponentScan(basePackages = {"com.stacksimplify.restservices.Hello"
		,"com.stacksimplify.restservices.repositories"
		,"com.stacksimplify.restservices.controllers"
		,"com.stacksimplify.restservices.services"})
@EntityScan("com.stacksimplify.restservices.entities")
@EnableJpaRepositories("com.stacksimplify.restservices.repositories")
public class SpringbootBuildingblocks2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBuildingblocks2Application.class, args);
	}

}
