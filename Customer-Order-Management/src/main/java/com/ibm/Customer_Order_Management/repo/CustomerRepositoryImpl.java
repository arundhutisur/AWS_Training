package com.ibm.Customer_Order_Management.repo;

import java.util.List;
import java.util.UUID;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ibm.Customer_Order_Management.MyFactory.MySessionfactory;
import com.ibm.Customer_Order_Management.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository{
	
	private static SessionFactory sessionFactory;
	
	private List<Customer> customerList;
	
	static {
		try {
			sessionFactory = MySessionfactory.getSessionFactory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	@Override
	public Customer insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String customerId = UUID.randomUUID().toString();
		String [] str = customerId.split("-");
		customerId = str[0];
		customer.setCustomerId(customerId);
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.persist(customer);
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		TypedQuery<Customer> typedQuery = session.createQuery("from Customer c", Customer.class);
		customerList = typedQuery.getResultList();
		return customerList;
	}

	@Override
	public Customer findByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Customer customer=session.find(Customer.class, customerId);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.merge(customer);
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public void deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		Customer customer = findByCustomerId(customerId);
		if(customer == null)
			System.out.println("Customer not found");
		else {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(customer);
			session.getTransaction().commit();
			System.out.println("Customer deleted: " + customer);
		}
		
	}

}
