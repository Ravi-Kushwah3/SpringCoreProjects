package com.dl.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.dl.service.CricketBat;

@Component("cktr")
@PropertySource("com/dl/cfgs/info.properties")
public class Cricketer implements ApplicationContextAware{
	@Value("${cktr.name}")
	private String name;
	@Value("${cktr.jershyNo}")
	private String jershyNo;
	
	private ApplicationContext ctx;
	
	public Cricketer() {
		System.out.println("Cricketer:: 0-param construstor");
	}
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
	 System.out.println("Cricketer.setApplicationContext()");
	 this.ctx = ctx;
		
	}
	 
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
		CricketBat bat = ctx.getBean(CricketBat.class);
		int runs = bat.scoreRun();
		System.out.println(name+" scored is "+runs +"having jershy "+jershyNo);
	}
	 

}
