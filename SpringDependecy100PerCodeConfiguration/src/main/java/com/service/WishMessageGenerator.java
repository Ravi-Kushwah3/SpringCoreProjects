package com.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("wmg")
@Scope("prototype")
public class WishMessageGenerator {
	@Autowired
	public LocalDateTime dateTime;
	
	public String generateWishMessage(String user) {
		
		int hour = dateTime.getHour();
		if(hour<12) {
			return "Good Morning "+user;
		}
		else if(hour<16) {
			return "Good AfterNoon "+user;
		}
		if(hour<12) {
			return "Good Evening "+user;
		}
		else{
			return "Good Night "+user;
		}
	}

}
