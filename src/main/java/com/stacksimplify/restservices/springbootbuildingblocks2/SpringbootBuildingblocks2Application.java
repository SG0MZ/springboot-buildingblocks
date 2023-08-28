package com.stacksimplify.restservices.springbootbuildingblocks2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//Second Commit
@SpringBootApplication
@ComponentScan(basePackages = "com.stacksimplify.restservices.Hello")
public class SpringbootBuildingblocks2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBuildingblocks2Application.class, args);
	}

}
