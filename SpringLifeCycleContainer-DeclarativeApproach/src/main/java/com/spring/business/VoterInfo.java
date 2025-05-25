package com.spring.business;

import java.util.Date;

public class VoterInfo {
	private String name;
	private Integer age;
	private Date dov;
 
	public void setName(String name) {
		this.name = name;
		System.out.println("VoterInfo.setName()");
	}
	public void setAge(Integer age) {
		this.age = age;
		System.out.println("VoterInfo.setAge()");
	}
	
	public void myInit() {
		System.out.println("VoterInfo.myInit()");
		dov = new Date();
		if(name == null || age <=0) {
			throw new IllegalArgumentException();
		}
	}
	public void myDestroy() {
		System.out.println("VoterInfo.myDestroy()");
	}
	public String checkVerificationInfo() {
		System.out.println("VoterInfo.checkVerificationInfo()");
		if(age<18) {
			return "u r not eligible with age "+age+" having name "+name+" & dov "+dov;
		}else {
			return "u r eligible with age "+age+" having name "+name+" & dov "+dov;
		}
	}
	

}
