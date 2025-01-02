package com.amazone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component("amazone")
public class AmazoneImpl implements Amazone {

	/*
	 * This method will return the product name which added in cart
	 * 
	 */

	@Override
	public List<String> addToCart(List<String> product) {
		System.out.println("FlipkartImpl.addToCart()");
		System.out.println("Your Item is added successfuly");
		return product;
	}

	/*
	 * This method will return the product buy status
	 * 
	 */
	@Override
	public boolean buyProduct(List<String> product, Scanner sc) {
		boolean paymentStatus = false;
		System.out.println("Do you want to payment now.\n" + "YES or NO");
		String status = sc.nextLine();
		if (status.equalsIgnoreCase("YES")) {
			paymentStatus = true;
		} else {
			paymentStatus = false;
		}
		return paymentStatus;
	}

	/* This method will select the from list */
	@Override
	public List<String> selectProduct(Scanner sc) {
		String cardStatus = "";
		System.out.println("FlipkartImpl.selectProduct()");
		List<String> product = new ArrayList<>();
		System.out.println("Select product\n" + "1.Watch\n" + "2.Mobile\n" + "3.Laptop");
		switch (Integer.parseInt(sc.nextLine())) {

		case 1:
			product.add("Watch");
			System.out.println("Do you want to add in cart.\n" + "YES or NO");
			cardStatus = sc.nextLine();
			if (cardStatus.equalsIgnoreCase("YES")) {
				addToCart(product);
			} else {
				product.clear();
			}
			break;
		case 2:
			product.add("Mobile");
			System.out.println("Do you want to add in cart.\n" + "YES or NO");
			cardStatus = sc.nextLine();
			if (cardStatus.equalsIgnoreCase("YES")) {
				addToCart(product);
			} else {
				product.clear();
			}
			break;
		case 3:
			product.add("Laptop");
			System.out.println("Do you want to add in cart.\n" + "YES or NO");
			cardStatus = sc.nextLine();
			if (cardStatus.equalsIgnoreCase("YES")) {
				addToCart(product);
			} else {
				product.clear();
			}
			break;
		default:
			System.out.println("No item selected");
		}

		return product;
	}

}
