package com.ibm.Customer_Order_Management;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.ibm.Customer_Order_Management.model.Customer;
import com.ibm.Customer_Order_Management.model.Order;
import com.ibm.Customer_Order_Management.service.CustomerService;
import com.ibm.Customer_Order_Management.service.CustomerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static CustomerService customerService;
    
	static {
		customerService = new CustomerServiceImpl();
	}
	public static void main( String[] args )
    {
		
		/*
		 * Order order = new Order(); String orderId = UUID.randomUUID().toString();
		 * String [] str = orderId.split("-"); orderId = str[0];
		 * order.setOrderId(orderId); order.setOrderType("Garments");
		 * order.setOrderPrice(10087.25); order.setConfirmed(true);
		 * 
		 * Customer customer = new Customer("John Doe", order);
		 * 
		 * customer = customerService.insertCustomer(customer);
		 * System.out.println("Customer inserted: " + customer);
		 */
		  
			/*
			 * List<Customer> customers = customerService.getCustomer(); for ( Customer c:
			 * customers) System.out.println(c);
			 * 
			 * 
			 * Customer c = null; c =
			 * customerService.findByCustomerId("f38d43f5-3f35-4ce9-962e-57f82e7952"); if(c
			 * == null) System.out.println("Customer not found"); else
			 * System.out.println("Customer found: " + c);
			 */
			
			/*
			 * Customer c1 = customerService.findByCustomerId("3eb2d34d");
			 * c1.setCustomerName("Mary Lawrence");
			 * c1.getCustomerOrderId().setOrderType("Groceries"); c1 =
			 * customerService.updateCustomer(c1); System.out.println("Customer updated: " +
			 * c1);
			 */
		customerService.deleteCustomer("3dc7e683-d3a1-48df-baec-bbd7ff6f63ca");
			
    }
}
