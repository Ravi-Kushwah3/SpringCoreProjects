package com.dl.model;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.dl.service.CricketBat;

@Component("cktr")
@PropertySource("com/dl/cfgs/info.properties")
public interface Cricketer {
	@Value("${cktr.name}")
     String name = null;
	@Value("${cktr.jershyNo}")
	 String jershyNo = null;
 
	 
   default void boalling() {
		System.out.println(name +" is boalling with jershyNo. "+jershyNo);
	}
   default void fielding() {
		System.out.println(name +" is fielding with jershyNo. "+jershyNo);
	}
	
   default void wicketKeeping() {
		System.out.println(name +" is wicketKeeping with jershyNo. "+jershyNo);
	}
	@Lookup
	public  CricketBat getCricketBat();
	
	default void batting() {
 		CricketBat bat = getCricketBat();
		int runs = bat.scoreRun();
		System.out.println(name+" scored is "+runs +" having jershy "+jershyNo);
	}

}
