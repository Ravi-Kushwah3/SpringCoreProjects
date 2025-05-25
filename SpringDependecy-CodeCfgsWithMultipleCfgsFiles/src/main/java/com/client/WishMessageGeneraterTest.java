package com.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cfgs.AppConfig;
import com.service.WishMessageGenerator;

public class WishMessageGeneraterTest {

	public static void main(String[] args) {
		 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		 
		 WishMessageGenerator wmg1 = ctx.getBean("wmg",WishMessageGenerator.class);
		 
		 String result = wmg1.generateWishMessage();
		 WishMessageGenerator wmg = ctx.getBean("wmg",WishMessageGenerator.class);

		 System.out.println("wmg1==wmg :: "+(wmg1==wmg) +" HashCode : "+
		 wmg1.hashCode()+", "+wmg.hashCode());
		 System.out.println("wmg==wmg :: "+(wmg==wmg) +" HashCode : "+
				 wmg.hashCode()+", "+wmg.hashCode());
		 
		 System.out.println(result);

	}

}
