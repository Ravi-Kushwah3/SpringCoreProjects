package com.client;

import com.component.Flipkart;
import com.factory.FlipkartFactory;

public class Test {
	public static void main(String[] args) throws Exception {
		FlipkartFactory factory = new FlipkartFactory();	
		Flipkart fk;
		try {
			fk = factory.getInstance();
			String message = fk.shopping(new String[] {"Apple","Orange","Banana","Mango"}, new double[] {2000.0,500.0,8000.0,562.0});
			System.out.println(message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
