package com.walker.restfulapiprojectseed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com"})
public class RestfulApiProjectSeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApiProjectSeedApplication.class, args);
	}
}
