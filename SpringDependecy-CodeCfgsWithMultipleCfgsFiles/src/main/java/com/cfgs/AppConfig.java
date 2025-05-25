package com.cfgs;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.nt.dao.SpringDAO;
import com.nt.sbeans.SpringDemoBean;
import com.nt.service.SpringService;

@Configuration
@ComponentScan(basePackages = "com")
@Import({SpringDAO.class,SpringService.class,SpringDemoBean.class})
public class AppConfig {
	@Bean(name = "ldt")
	public LocalDateTime getLocalDate() {
		return LocalDateTime.now();
	}

}
