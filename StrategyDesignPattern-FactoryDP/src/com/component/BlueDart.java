package com.component;

public class BlueDart implements Courier {
	
	public BlueDart() {
		System.out.println("BlueDart.BlueDart()");
	}

	@Override
	public final String delevery(int oid) {
		return oid+" oid order is delevered by BlueDart";
	}
}
