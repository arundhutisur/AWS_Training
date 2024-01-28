package com.ibm.Customer_Order_Management.MyFactory;

import org.hibernate.SessionFactory;


import org.hibernate.cfg.Configuration;

import com.ibm.Customer_Order_Management.model.Order;
import com.ibm.Customer_Order_Management.model.Customer;

public class MySessionfactory {
	
	private static SessionFactory sessionFactory;
	
	static
	{
		try {
			sessionFactory=new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Order.class).buildSessionFactory();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static SessionFactory getSessionFactory()throws Exception {
		return sessionFactory;
	}

}
