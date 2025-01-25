package com.factory;

import com.component.BlueDart;
import com.component.Courier;
import com.component.DHL;
import com.component.Flipkart;

public class FlipkartFactory {
	public FlipkartFactory() {
	 System.out.println("FlipkartFactory.FlipkartFactory()");
	}
   public Flipkart getInstance(String courierType) {
	   Courier courier = null;
	   if(courierType == "dhl") {
		   courier = new DHL();
	   }else if(courierType == "bDart") {
		   courier = new BlueDart();
	   }
	   else {
		   throw new IllegalArgumentException("Invalid Courier type");
	   }
	   Flipkart flk = new Flipkart();
	   flk.setCourier(courier);
	   return flk;
   }
}
