package com.example.myexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.myexamples.config.AppConfig;

@SpringBootApplication
public class MyexamplesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyexamplesApplication.class, args);
		AppConfig appConfig = context.getBean(AppConfig.class);
		appConfig.getCacheManager().initiateCache();
	}
}
