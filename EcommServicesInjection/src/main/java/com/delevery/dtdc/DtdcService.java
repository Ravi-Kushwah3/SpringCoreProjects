package com.delevery.dtdc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beansutility.BeansUtility;
import com.serviceprovider.ServiceProvider;

@Component("dtdc")
public class DtdcService {
 
	@Autowired
	private LocalDateTime localDate;
	private static final String BOLD = "\033[1m";
	private static final String RESET = "\033[0m";

	public void deleverProduct(List<String> product, Scanner sc, BeansUtility utility,ServiceProvider serviceProvider) {
		System.out.println("DtdcService.deleverProduct()");
		List<String> address = takeDeleveryAddressDetails(sc);
		generateBillingDetails(address, product, utility, serviceProvider);
		System.out.println("\nYour " + product.get(0) + " is delevered successfuly.");
	}

	public List<String> takeDeleveryAddressDetails(Scanner sc) {
		List<String> address = new ArrayList<>();
		System.out.println("Please enter  your address details.\n");
		System.out.print("Name: ");
		address.add(sc.nextLine());

		System.out.print("Phone No.: ");
		address.add(sc.nextLine());

		System.out.print("PinCode: ");
		address.add(sc.nextLine());

		System.out.print("State: ");
		address.add(sc.nextLine());

		System.out.print("City: ");
		address.add(sc.nextLine());

		System.out.print("Landmark: ");
		address.add(sc.nextLine());
		return address;
	}
	public void generateBillingDetails(List<String> addressDetails,List<String> product,BeansUtility utility,ServiceProvider serviceProvider) {
		String fullAddress = String.join(", ", addressDetails.get(5), addressDetails.get(4));
		String picodeState = String.join(", ", addressDetails.get(3), addressDetails.get(2));

		StringBuilder sb = new StringBuilder();
		sb.append(" _______________________________________________________________________________________\n");
        sb.append("!                                                                                       !\n"); 
        sb.append("|                     " + BOLD + "BILLING DETAILS" + RESET + "                                                   |\n");
        sb.append("!_______________________________________________________________________________________!\n");
        sb.append(String.format("| Item Quantity.               |     %-50s |\n", product.size()));
        sb.append(String.format("| Item Name                    |     %-50s |\n", product.get(0)));
        sb.append(String.format("| Total Amount                 |     %-50s |\n", "100rs"));
        sb.append(String.format("| Receiver                     |     %-50s |\n", addressDetails.get(0)));
        sb.append(String.format("| Contact No.                  |     %-50s |\n", addressDetails.get(1)));
        sb.append(String.format("| Address                      |     %-50s |\n", fullAddress));
        sb.append(String.format("|                              |     %-50s |\n", picodeState ));
        sb.append(String.format("| Date                         |     %-50s |\n", getCurrentDateTime()));
        sb.append("|'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''|\n");
        sb.append(String.format("|                       Thankyou shopping with %-40s |\n", serviceProvider.getService_Provider_Name()));
        sb.append("!.......................................................................................!\n");
        System.out.println(sb.toString());
	}
	public String getCurrentDateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm:ss a");
		String formattedDateTime = localDate.format(dtf);
		return formattedDateTime;
	}
	
	public static void main(String[] args) {
		 
		//takeDeleveryAddressDetails(new Scanner(System.in));
		
		StringBuilder sb = new StringBuilder();
		sb.append("_______________________________________________________________________________________\n");
        sb.append("!                                                                                       !\n"); 
        sb.append("|                     " + BOLD + "BILLING DETAILS" + RESET + "                                                   |\n");
        sb.append("!_______________________________________________________________________________________!\n");
        
        System.out.println(sb);
	}


}
