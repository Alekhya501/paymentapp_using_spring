package com.alekhya.paymentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alekhya.paymentapp.entities.BankAccountEntity;
import com.alekhya.paymentapp.entities.UserEntity;
import com.alekhya.paymentapp.services.BankService;
import com.alekhya.paymentapp.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {
	@Autowired
	UserService userService;
	@Autowired
	BankService bankService;

	@GetMapping("/dashboard")
	public String user(Model model,HttpSession session) {
		int userId=(int) session.getAttribute("userId");
		System.out.println(userId);
		UserEntity user=userService.getUserById(userId);
		model.addAttribute("user", user);
		List<BankAccountEntity> userBankAccs=bankService.getAccountsByUserId(userId);
		model.addAttribute("bankAccs", userBankAccs);

		
		return "dashboard";
	}

}
