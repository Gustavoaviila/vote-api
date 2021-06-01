package com.voteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VsScheduleApplication {


	public static void main(String[] args) {
		SpringApplication.run(VsScheduleApplication.class, args);
		
		
	}

}
