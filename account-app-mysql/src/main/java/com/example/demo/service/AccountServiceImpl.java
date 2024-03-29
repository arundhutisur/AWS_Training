package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.model.Account;
import com.example.demo.repo.AccountRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component(value = "accountService")
public class AccountServiceImpl implements AccountService {
	private final AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.createAccount(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepository.getAllAccounts();
	}

	@Override
	public Account getAccountByaccountNumber(String accountNumber) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return accountRepository.getAccountByaccountNumber(accountNumber);
	}

	@Override
	public Account updateAccountByAccountNumber(String accountNumber, Account account) throws AccountNotFoundException {
		return accountRepository.updateAccountByAccountNumber(accountNumber, account);
	}

	@Override
	public void deleteAccount(String accountNumber) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		accountRepository.deleteAccount(accountNumber);
	}

	@Override
	public Account getAccountByEmail(String email) throws AccountNotFoundException {
		return accountRepository.getAccountByEmail(email);
	}

	@Override
	public Account depositAmount(String accountNumber, Account account) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return accountRepository.depositAmount(accountNumber, account);
	}

	@Override
	public Account withdrawAmount(String accountNumber, Account account) throws Exception {
		// TODO Auto-generated method stub
		return accountRepository.withdrawAmount(accountNumber, account);
	}

}