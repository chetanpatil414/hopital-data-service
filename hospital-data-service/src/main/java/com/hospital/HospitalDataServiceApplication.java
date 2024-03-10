package com.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HospitalDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalDataServiceApplication.class, args);
	}

}
