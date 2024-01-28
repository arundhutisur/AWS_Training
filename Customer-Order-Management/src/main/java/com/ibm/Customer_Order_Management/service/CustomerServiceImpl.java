package com.ibm.Customer_Order_Management.service;

import java.util.List;

import com.ibm.Customer_Order_Management.model.Customer;
import com.ibm.Customer_Order_Management.repo.CustomerRepository;
import com.ibm.Customer_Order_Management.repo.CustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService{
	
	private static CustomerRepository customerRepository;
	
	static {
		customerRepository = new CustomerRepositoryImpl();
	}
	@Override
	public Customer insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.insertCustomer(customer);
	}
	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.getCustomer();
	}
	@Override
	public Customer findByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomerId(customerId);
	}
	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.updateCustomer(customer);
	}
	@Override
	public void deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		customerRepository.deleteCustomer(customerId);
		
	}

}
