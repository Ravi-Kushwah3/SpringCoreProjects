package com.rk;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.rk.bean.Printer;
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
			Printer pobj1 = ctx.getBean("p1",Printer.class);
			Printer pobj2 = ctx.getBean("p2",Printer.class);
			
			System.out.println("pobj1 == pobj2? "+(pobj1 == pobj2));

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (ctx != null) {
				ctx.close();
			}
		}
	}

}
