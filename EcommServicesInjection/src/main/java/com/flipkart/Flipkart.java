package com.flipkart;

import java.util.List;
import java.util.Scanner;

public interface Flipkart {
	public List<String> addToCart(List<String> product);
	public boolean buyProduct(List<String> product,Scanner sc);
	public List<String> selectProduct(Scanner sc);

}
