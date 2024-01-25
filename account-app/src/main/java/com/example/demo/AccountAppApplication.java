package com.example.demo;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.model.Account;
import com.example.demo.repo.AccountRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@SpringBootApplication
@EnableDiscoveryClient
public class AccountAppApplication implements CommandLineRunner {
private final AccountRepository accountRepository;
	public static void main(String[] args) {
		SpringApplication.run(AccountAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountRepository.createAccount(new Account(UUID.randomUUID().toString(), "Sachin", "Mumbai", "sachin@email.com"));
		accountRepository.createAccount(new Account(UUID.randomUUID().toString(), "Rahul", "Banglore", "rahul@email.com"));
		
		
	}

}