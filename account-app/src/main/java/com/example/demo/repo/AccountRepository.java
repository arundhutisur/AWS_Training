package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.model.Account;
@Component(value = "accountRepository")
public interface AccountRepository {
	
	Account createAccount(Account account);
	
	List<Account> getAllAccounts();
	
	Account getAccountByaccountNumber(String accountNUmber) throws AccountNotFoundException;
	
	Account updateAccountByAccountNumber(String accountNumber, Account account)throws AccountNotFoundException;
	
	void deleteAccount(String accountNumber) throws AccountNotFoundException;
	
	Account getAccountByEmail(String email) throws AccountNotFoundException;
}