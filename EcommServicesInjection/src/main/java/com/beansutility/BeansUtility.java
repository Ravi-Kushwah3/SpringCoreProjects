package com.beansutility;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.amazone.AmazoneImpl;
import com.delevery.bluedart.BlueDart;
import com.delevery.dtdc.DtdcService;
import com.flipkart.FlipkartImpl;
import com.serviceprovider.ServiceProvider;

@Component("utility")
public class BeansUtility {

	private FileSystemXmlApplicationContext container;
	private BlueDart bluedart;
	private DtdcService dtdc;
	private FlipkartImpl flipkart;
	private AmazoneImpl amazone;
	private ServiceProvider serviceProvider;
	private BeansUtility beansUtility;

	public BlueDart getBluedart() {
		return bluedart;
	}

	public void setBluedart(BlueDart bluedart) {
		bluedart = (BlueDart) getContainer().getBean("bluedart");
		this.bluedart = bluedart;
	}

	public DtdcService getDtdc() {
		return dtdc;
	}

	public void setDtdc(DtdcService dtdc) {
		dtdc = (DtdcService) getContainer().getBean("dtdc");
		this.dtdc = dtdc;
	}

	public AmazoneImpl getAmazone() {
		return amazone;
	}

	public void setAmazone(AmazoneImpl amazone) {
		amazone = (AmazoneImpl) getContainer().getBean("amazone");
		this.amazone = amazone;
	}

	public FileSystemXmlApplicationContext getContainer() {
		return container;
	}

	public FlipkartImpl getFlipkart() {
		return flipkart;
	}

	public void setFlipkart(FlipkartImpl flipkart) {
		flipkart = (FlipkartImpl) getContainer().getBean("flipkart");
		this.flipkart = flipkart;
	}

	public void setContainer(FileSystemXmlApplicationContext container, BeansUtility utility) {
		this.container = container;
		utility.setBeansUtility(utility);
		utility.setFlipkart(flipkart);
		utility.setAmazone(amazone);
		utility.setBluedart(bluedart);
		utility.setDtdc(dtdc);
		utility.setServiceProvider(serviceProvider);

	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		serviceProvider = (ServiceProvider) getContainer().getBean("service_provider");
		this.serviceProvider = serviceProvider;
	}

	public BeansUtility getBeansUtility() {
		return beansUtility;
	}

	public void setBeansUtility(BeansUtility beansUtility) {
		beansUtility = (BeansUtility) getContainer().getBean("utility");
		this.beansUtility = beansUtility;
	}

}
