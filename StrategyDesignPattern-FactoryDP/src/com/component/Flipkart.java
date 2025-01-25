package com.component;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart {
	private Courier courier;
	public Flipkart() { 
		System.out.println("Flipkart.Flipkart()");
	}
	public void setCourier(Courier courier) {
		System.out.println("Flipkart.setCourier()");
		this.courier = courier;
	}
	
	public String shopping(String[] items,double [] price) {
		int oid = new Random().nextInt(100000);
		String msg = courier.delevery(oid);
		double billAmt = 0.0;
		for(double amt : price) {
			billAmt = billAmt + amt;
		}
		return Arrays.toString(items)+" items are purchase having bill amount "+ billAmt +" --> "+msg;
	}
 

}
