package com.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.BankService;

public class MethodReplacerTest {

	public static void main(String[] args) {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/cfgs/applicationContext.xml");
	
	BankService service = ctx.getBean("bank",BankService.class);
	
	double amount = service.calculateInterastRate(10000.0, 2.0, 2.0);
	
	System.out.println("Proxy class : "+service.getClass()+"  superClass : "+service.getClass().getSuperclass());
	System.out.println("Declared all method in proxy class : "+ Arrays.toString(service.getClass().getDeclaredMethods()));
	System.out.println("simple interest : "+amount);
	

	}

}
