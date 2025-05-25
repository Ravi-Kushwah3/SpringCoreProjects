package com.dl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dl.model.Cricketer;

public class CricketTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/dl/cfgs/applicationContext.xml");
		Cricketer cktr = ctx.getBean(Cricketer.class);
		System.out.println("proxy class : "+cktr.getClass().getName());
		System.out.println("super class :"+cktr.getClass().getSuperclass().getName());
		cktr.boalling();
		cktr.fielding();
		cktr.wicketKeeping();
		cktr.batting();
	}

}
