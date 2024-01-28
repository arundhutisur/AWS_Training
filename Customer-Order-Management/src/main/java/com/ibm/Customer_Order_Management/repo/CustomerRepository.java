package com.ibm.Customer_Order_Management.repo;

import java.util.List;

import com.ibm.Customer_Order_Management.model.Customer;

public interface CustomerRepository {
	Customer insertCustomer(Customer customer);
	List<Customer> getCustomer();
	Customer findByCustomerId(String customerId);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(String customerId);
}
