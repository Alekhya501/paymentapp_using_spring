package com.alekhya.paymentapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alekhya.paymentapp.dtos.BankAccountDto;
import com.alekhya.paymentapp.entities.BankAccountEntity;
import com.alekhya.paymentapp.entities.UserEntity;
import com.alekhya.paymentapp.services.BankService;
import com.alekhya.paymentapp.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AddBankAccountController {
	@Autowired
	BankService bankService;
	@Autowired
	UserService userService;

	@GetMapping("/addnewbankaccount")
	public String showAdddBankAccountForm() {
		return "addBankAccount";
	}

	@PostMapping("/addnewbankaccount")
	public String addingBankAccount(@ModelAttribute BankAccountDto bankAccDto, HttpSession session) {
		BankAccountEntity bankAccEntity = new BankAccountEntity();
		bankAccEntity.setAccountNumber(bankAccDto.getAccountNumber());
		bankAccEntity.setBankName(bankAccDto.getBankName());
	
		bankAccEntity.setBalance(bankAccDto.getBalance());
		bankAccEntity.setIfscCode(bankAccDto.getIfscCode());
		bankAccEntity.setBranchLocation(bankAccDto.getBranchLocation());
		bankAccEntity.setIsActive(bankAccDto.getIsActive());
		

		int userId=(int) session.getAttribute("userId");
		UserEntity loggedInUser = userService.getUserById(userId);

		if (loggedInUser!=null) {
		
			bankAccEntity.setUser(loggedInUser);

			bankService.addBankAccount(bankAccEntity);

			return "redirect:/dashboard";
		}
		return "failed to create bank Account";

	}
	

}
