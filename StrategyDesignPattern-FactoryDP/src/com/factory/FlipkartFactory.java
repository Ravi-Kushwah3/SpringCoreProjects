package com.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import com.component.Courier;
import com.component.Flipkart;

public class FlipkartFactory {
	private static Properties prop;
	public FlipkartFactory() {
	 System.out.println("FlipkartFactory.FlipkartFactory()");
	}
	static {
		try {
			InputStream in = new FileInputStream("src/com/commons/info.properties");
			prop = new Properties();
			prop.load(in);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Flipkart getInstance(/* String courierType */) throws Exception {
	   Courier courier = null;
//	   if(courierType == "dhl") {
//		   courier = new DHL();
//	   }else if(courierType == "bDart") {
//		   courier = new BlueDart();
//	   }
//	   else {
//		   throw new IllegalArgumentException("Invalid Courier type");
//	   }
	  String courierType = prop.getProperty("courier.name");
	   
	   Class c = Class.forName(courierType);
	   try {
		   // deprecated method 
		//courier = (Courier) c.newInstance();
		   Constructor[] cons = c.getDeclaredConstructors();
		   //0-param constructer
		   courier =(Courier) cons[0].newInstance();
	} catch (Exception e ) {
		e.printStackTrace();
	}
	   Flipkart flk = new Flipkart();
	   flk.setCourier(courier);
	   return flk;
   }
}
