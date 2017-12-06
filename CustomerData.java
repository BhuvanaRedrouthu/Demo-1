package com.simplify.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerData {

	private static List<String> customerIds = new ArrayList<String>();
	
	public static  List<String> getCustIds() {
		return customerIds;
	}
	
	public static void addCustomerId(String customerId) {
		customerIds.add(customerId);
	}
}
