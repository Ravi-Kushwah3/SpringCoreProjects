package com.spring.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.business.VoterInfo;

public class SpringLifeCycleTest {
	
	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/spring/cfgs/applicationContext.xml")){
			
			VoterInfo voter = ctx.getBean("voter",VoterInfo.class);
			
			String result = voter.checkVerificationInfo();
			
			System.out.println(result);
			
		}catch(Exception e) {
			System.err.println(e);
		}
	}

}
