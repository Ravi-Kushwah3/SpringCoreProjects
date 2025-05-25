package com.spring.business;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class VoterInfo implements InitializingBean, DisposableBean {
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

	public String checkVerificationInfo() {
		System.out.println("VoterInfo.checkVerificationInfo()");
		if (age < 18) {
			return "u r not eligible with age " + age + " having name " + name + " & dov " + dov;
		} else {
			return "u r eligible with age " + age + " having name " + name + " & dov " + dov;
		}
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("VoterInfo.destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("VoterInfo.afterPropertiesSet()");
		dov = new Date();
		if (name == null || age <= 0) {
			throw new IllegalArgumentException();
		}

	}

}
