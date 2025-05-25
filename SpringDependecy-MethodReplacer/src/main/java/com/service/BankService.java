package com.service;

import org.springframework.stereotype.Component;

@Component("bank")
public class BankService {
	public double calculateInterastRate(double pamt,double rate,double time) {
		System.out.println("BankService.calculateInterastRate()");
		return (pamt*Math.pow((1+rate/100), time))-pamt;
	}

}
