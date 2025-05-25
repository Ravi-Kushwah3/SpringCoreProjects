package com.rk.bean;

public class Printer {

	public static Printer INSTANSE;

	private Printer() {
		System.out.println("Printer.Printer()");
	}

	public static Printer getInstanse() {
		if (INSTANSE == null) {
			INSTANSE = new Printer();

		}
		return INSTANSE;
	}

}
