package com.mthdRep;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class InterestMethodReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("InterestMethodReplacer.reimplement()");
		double pamt = (double)args[0];
		double rate = (double)args[1];
		double time = (double)args[2];
 		return (pamt*rate*time)/100;
	}

}
