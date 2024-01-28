package com.ibm.Customer_Order_Management.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Customers")
public class Customer {
	
	@Id
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "customer_name")
	private String customerName;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order customerOrderId;
	
	
	public Customer(String customerName, Order customerOrderId) {
		super();
		this.customerName = customerName;
		this.customerOrderId = customerOrderId;
	}
	
}
