package com.rk.bean;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("season")
public class SeasonFinder {
	@Autowired
	@Qualifier("ldt2")
	private LocalDateTime localDate;

	public SeasonFinder() {
		System.out.println("SeasonFinder.SeasonFinder()");
	}

	public String findSeason(String name) {
		System.out.println("SeasonFinder.findSeason()");

		try {
			System.out.println("Date : "+localDate.getYear());
			int month = localDate.getMonthValue();
			if (month <= 3) {
				return "Welcome in Winter " + name;
			} else if (month < 3 && month > 6) {
				return "Welcome in  Summer " + name;
			} else if (month < 6 && month > 9) {
				return "Welcome in Spring " + name;
			} else {
				return "Welcome in Summer " + name;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}
}
