package com.dl.model;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.dl.service.CricketBat;

@Component("cktr")
@PropertySource("com/dl/cfgs/info.properties")
public class Cricketer {
	@Value("${cktr.name}")
	private String name;
	@Value("${cktr.jershyNo}")
	private String jershyNo;
 
	 
	public void boalling() {
		System.out.println(name +" is boalling with jershyNo. "+jershyNo);
	}
	public void fielding() {
		System.out.println(name +" is fielding with jershyNo. "+jershyNo);
	}
	
	public void wicketKeeping() {
		System.out.println(name +" is wicketKeeping with jershyNo. "+jershyNo);
	}
	
	public void batting() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/dl/cfgs/applicationContext.xml");
		CricketBat bat = ctx.getBean(CricketBat.class);
		int runs = bat.scoreRun();
		System.out.println(name+" scored is "+runs +"having jershy "+jershyNo);
	}

}
