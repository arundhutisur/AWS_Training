package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "account_table")
public class Account {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(message="account number cannot be null")
	@NotBlank(message="account number cannot be blank")
	@Column(name = "account_number")
	private String accountNumber;
	
	@NotNull(message="account holder name cannot be null")
	@Length(min=4, max=20,message="account holder name is wrong")
	@Column(name = "account_holder_name")
	private String accountHolderName;
	
	@Column(name = "account_holder_address")
	private String accountHolderAddress;
	
	@Email(message="invalid email")
	@Column(name = "account_holder_email")
	private String email;
	
	@Min(value = 50,message="minimum amount required")
	@Max(value = 50000,message="maximum amount reached")
	@Column(name="amount")
	private float amount;
	public Account(String accountHolderName, String accountHolderAddress, String email, float amount) {
		super();
		this.accountHolderName = accountHolderName;
		this.accountHolderAddress = accountHolderAddress;
		this.email = email;
		this.amount = amount;
	}
	public Account(float amount) {
		super();
		this.amount = amount;
	}
}