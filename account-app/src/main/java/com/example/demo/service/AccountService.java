package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.model.Account;

public interface AccountService {
	Account createAccount(Account account);

	List<Account> getAllAccounts();
	
	Account getAccountByaccountNumber(String accountNUmber)throws AccountNotFoundException;
	
	Account updateAccountByAccountNumber(String accountNumber, Account account)throws AccountNotFoundException;
	
	void deleteAccount(String accountNumber) throws AccountNotFoundException;
	
	Account getAccountByEmail(String email) throws AccountNotFoundException;
}