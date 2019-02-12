package com.lti.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@AutoConfigurationPackage
@ComponentScan(basePackages= "com.lti")
@EntityScan(basePackages="com.lti")
public class BusResApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusResApplication.class, args);
	}

}

