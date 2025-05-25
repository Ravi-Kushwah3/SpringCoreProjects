package com.spring.business;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component("voter")
@PropertySource("com/spring/cfgs/application.properties")
public class VoterInfo{
	@Value("${voter.name}")
	private String name;
	@Value("${voter.age}")
	private Integer age;
	private Date dov;
	
	@PostConstruct
	public void myInit() {
		System.out.println("VoterInfo.myInit()");
		dov = new Date();
		if (name == null || age <= 0) {
			throw new IllegalArgumentException();
		}
		
	}
	@PreDestroy
	public void myDestroy() {
		System.out.println("VoterInfo.myDestroy()");
		
	}

	public String checkVerificationInfo() {
		System.out.println("VoterInfo.checkVerificationInfo()");
		if (age < 18) {
			return "u r not eligible with age " + age + " having name " + name + " & dov " + dov;
		} else {
			return "u r eligible with age " + age + " having name " + name + " & dov " + dov;
		}
	}

}
