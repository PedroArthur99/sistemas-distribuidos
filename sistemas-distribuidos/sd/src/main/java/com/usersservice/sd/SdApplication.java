package com.usersservice.sd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdApplication.class, args);
	}

}
