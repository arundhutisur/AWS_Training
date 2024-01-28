package com.ibm.Customer_Order_Management.service;

import java.util.List;

import com.ibm.Customer_Order_Management.model.Customer;

public interface CustomerService {
	Customer insertCustomer(Customer customer);
	
	List<Customer> getCustomer();
	
	Customer findByCustomerId(String customerId);
	
	Customer updateCustomer(Customer customer);
	
	void deleteCustomer(String customerId);

}
