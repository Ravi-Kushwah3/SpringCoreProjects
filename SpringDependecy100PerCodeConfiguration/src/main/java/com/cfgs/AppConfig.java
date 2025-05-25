package com.cfgs;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com")
public class AppConfig {
	@Bean(name = "ldt")
	public LocalDateTime getLocalDate() {
		return LocalDateTime.now();
	}

}
