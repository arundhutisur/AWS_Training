
package com.example.demo.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.model.Account;

import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component(value = "accountRepository")
@EnableTransactionManagement
public class AccountRepositoryImpl implements AccountRepository {

	private final SessionFactory sessionFactory;

	@Override

	@Transactional
	public Account createAccount(Account account) { // TODO
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.persist(account);
		session.getTransaction().commit();
		return account;
	}

	@Override
	public List<Account> getAllAccounts() { // TODO Auto-generated
		Session session = sessionFactory.openSession();
		TypedQuery<Account> query = session.createQuery("FROM Account A", Account.class);
		return query.getResultList();
	}

	@Override
	public Account getAccountByaccountNumber(String accountNUmber) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Account account=session.get(Account.class, accountNUmber);
		if(account==null)
		{
			throw new AccountNotFoundException("account with "+accountNUmber+" not found");
		}
		return account;
	}

	@Override
	public Account updateAccountByAccountNumber(String accountNumber, Account account) throws AccountNotFoundException {
		Account tempAccount = getAccountByaccountNumber(accountNumber);
		if (tempAccount == null) {
			throw new com.example.demo.exception.AccountNotFoundException("account with " + accountNumber + " not found");
		}
		Session session = sessionFactory.openSession();
		tempAccount.setAccountHolderName(account.getAccountHolderName());
		tempAccount.setAccountHolderAddress(account.getAccountHolderAddress());
		tempAccount.setEmail(account.getEmail());
		session.getTransaction().begin();
		session.merge(tempAccount);
		session.getTransaction().commit();
		return tempAccount;
	}

	@Override
	public void deleteAccount(String accountNumber) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		Account tempAccount = getAccountByaccountNumber(accountNumber);
		if (tempAccount == null) {
			throw new com.example.demo.exception.AccountNotFoundException("account with " + accountNumber + " not found");
		}
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.remove(session.merge(tempAccount));
		session.getTransaction().commit();
	}

	@Override
	public Account getAccountByEmail(String email) throws AccountNotFoundException {
		Session session = sessionFactory.openSession();
		TypedQuery<Account> query=session.createQuery("FROM Account A where A.email=:email",Account.class);
		query.setParameter("email", email);
		if(query.getResultList().size()>0) {
			return query.getResultList().get(0);
		}
		else {
			throw new com.example.demo.exception.AccountNotFoundException("account with " + email + " not found");
		}
	}
}