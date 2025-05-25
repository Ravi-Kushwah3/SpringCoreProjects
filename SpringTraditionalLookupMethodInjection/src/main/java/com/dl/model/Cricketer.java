package com.dl.model;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.dl.service.CricketBat;

@Component("cktr")
@PropertySource("com/dl/cfgs/info.properties")
public abstract class Cricketer {
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
	@Lookup
	public abstract CricketBat getCricketBat();
	
	public void batting() {
 		CricketBat bat = getCricketBat();
		int runs = bat.scoreRun();
		System.out.println(name+" scored is "+runs +"having jershy "+jershyNo);
	}

}
