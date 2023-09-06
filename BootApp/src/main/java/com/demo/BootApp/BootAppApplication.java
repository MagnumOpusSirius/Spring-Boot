package com.demo.BootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//responsible to perform all types of configuration. It performs autoconfiguration
@SpringBootApplication
public class BootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootAppApplication.class, args);
	}

}
