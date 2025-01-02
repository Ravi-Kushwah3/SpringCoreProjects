package com.client;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.amazone.AmazoneImpl;
import com.beansutility.BeansUtility;
import com.delevery.bluedart.BlueDart;
import com.delevery.dtdc.DtdcService;
import com.flipkart.FlipkartImpl;
import com.serviceprovider.ServiceProvider;
@Component 
public class EcommTest {
	@Autowired
	private BeansUtility utility;
	private Scanner scanner = null;

	public EcommTest() {
		this.scanner = new Scanner(System.in);
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/com/configuration/applicationContext.xml");
		utility = (BeansUtility)ctx.getBean("utility");
		utility.setContainer(ctx,utility);
	}

	public static void main(String[] args) {

		try {
			new EcommTest().doShopping();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

	public void doShopping() {
		try {
			List<String> produsctList = null;
			System.out.println("Choose Service Provider\n" + "1. Flipkart\n" + "2. Amazone");
			String serviceProvider = scanner.nextLine();
			switch (Integer.parseInt(serviceProvider)) {
			case 1:
				System.out.println("Go with flipkart");
				FlipkartImpl flpkart = utility.getFlipkart();
				produsctList = flpkart.selectProduct(scanner);
				if (produsctList.size() > 0) {
					boolean paymentStatus = flpkart.buyProduct(produsctList, scanner);
					if (paymentStatus) {
						System.out.println("Going to delever product");
						System.out.println("Select way of delevered product.\n" + "1.BlueDart\n" + "2.DTDC");
						ServiceProvider service_provider = utility.getServiceProvider();
						service_provider.setService_Provider_Name("Flipkart");
						while (true) {
							try {
								String medium = scanner.nextLine();
								if (Integer.parseInt(medium) == 1) {
									BlueDart blueDart = utility.getBluedart();
									blueDart.deleverProduct(produsctList, scanner, utility, service_provider);
									break;

								} else if (Integer.parseInt(medium) == 2) {
									DtdcService dtdc = utility.getDtdc();
									dtdc.deleverProduct(produsctList, scanner, utility, service_provider);
									break;
								} else {
									System.out.println("Enter correct option.");
								}
							} catch (Exception e) {
								System.err.println(e);
								System.out.println("Enter correct option.");
							}
						}
					} else {
						System.out.println("PayMent not happened.");
					}
				} else {
					System.out.println("No item selected");
				}
				break;
			case 2:
				System.out.println("WELCOME TO AMAZONE");
				AmazoneImpl amazone = utility.getAmazone();
				produsctList = amazone.selectProduct(scanner);
				if (produsctList.size() > 0) {
					boolean paymentStatus = amazone.buyProduct(produsctList, scanner);
					if (paymentStatus) {
						System.out.println("Going to delever product");
						System.out.println("Select way of delevered product.\n" + "1.BlueDart\n" + "2.DTDC");
						ServiceProvider service_provider = utility.getServiceProvider();
						service_provider.setService_Provider_Name("Amazone");
						while (true) {
							try {
								String medium = scanner.nextLine();
								if (Integer.parseInt(medium) == 1) {
									BlueDart blueDart = utility.getBluedart();
									blueDart.deleverProduct(produsctList, scanner, utility, service_provider);
									break;

								} else if (Integer.parseInt(medium) == 2) {
									DtdcService dtdc = utility.getDtdc();
									dtdc.deleverProduct(produsctList, scanner, utility, service_provider);
									break;
								} else {
									System.out.println("Enter correct option.");
								}
							} catch (Exception e) {
								System.err.println(e);
								System.out.println("Enter correct option.");
							}
						}
					} else {
						System.out.println("PayMent not happened.");
					}
				} else {
					System.out.println("No item added in cart.");
				}
				break;
			default:
				System.out.println("No interested now. !!");

			}

		} catch (Exception e) {
			System.err.println(e);
		}

	}
}
