package com.component;

public final class DHL implements Courier {

	public DHL() {
		System.out.println("DHL.DHL()");
	}

	@Override
	public final String delevery(int oid) {
		System.out.println("DHL.delevery()");
		return oid+" oid order is delevered by DHL";
	}
}
