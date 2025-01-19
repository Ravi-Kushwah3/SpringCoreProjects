package com.rk;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.rk.bean.SeasonFinder;

public class BeanClientApp {
	public static void main(String[] args) {
		FileSystemXmlApplicationContext ctx = null;
		try {
			System.out.println("BeanClientApp.main()");
			ctx = new FileSystemXmlApplicationContext("src/main/java/com/rk/cfg/applicationContext.xml");
			Object obj = ctx.getBean("season");
			SeasonFinder sf = (SeasonFinder) obj;
			String result = sf.findSeason("Ravi");
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (ctx != null) {
				ctx.close();
			}
		}
	}

}
