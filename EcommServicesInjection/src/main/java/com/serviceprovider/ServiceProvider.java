package com.serviceprovider;

import org.springframework.stereotype.Component;

@Component("service_provider")
public class ServiceProvider {
	private String service_Provider_Name;

	public String getService_Provider_Name() {
		return service_Provider_Name;
	}

	public void setService_Provider_Name(String service_Provider_Name) {
		this.service_Provider_Name = service_Provider_Name;
	}

}
