package com.team4.first_ui_.flow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@AutoConfiguration
public class FirstUiFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstUiFlowApplication.class, args);
	}

}
