package com.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("wmg")
@Scope("prototype")
@PropertySource("com/nt/cfgs/application.properties")
public class WishMessageGenerator {
	@Value("${person.name}")
	String name;
	@Autowired
	public LocalDateTime dateTime;
	
	public String generateWishMessage() {
		
		int hour = dateTime.getHour();
		if(hour<12) {
			return "Good Morning "+name;
		}
		else if(hour<16) {
			return "Good AfterNoon "+name;
		}
		if(hour<12) {
			return "Good Evening "+name;
		}
		else{
			return "Good Night "+name;
		}
	}

}
