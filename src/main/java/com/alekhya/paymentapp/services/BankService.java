package com.alekhya.paymentapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alekhya.paymentapp.entities.BankAccountEntity;
import com.alekhya.paymentapp.repositories.BankAccRepository;

@Service
public class BankService {
	@Autowired
	BankAccRepository bankRepo;
	public List<BankAccountEntity> getAccountsByUserId(int userId) {
	    return bankRepo.findByUserUserId(userId);
	}
	public void addBankAccount(BankAccountEntity bankAccEntity) {
		bankRepo.save(bankAccEntity);
		// TODO Auto-generated method stub
		
	}
	
	

}
