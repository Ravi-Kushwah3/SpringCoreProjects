package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SpringDemoBean {
	public SpringDemoBean() {
		System.out.println("SpringDemoBean.SpringDemoBean()");
	}

}
