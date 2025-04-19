package com.alekhya.paymentapp.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alekhya.paymentapp.dtos.sendMoneyDto;
import com.alekhya.paymentapp.entities.BankAccountEntity;
import com.alekhya.paymentapp.entities.TransactionEntity;
import com.alekhya.paymentapp.repositories.BankAccRepository;
import com.alekhya.paymentapp.repositories.TransactionRepository;
import com.alekhya.paymentapp.repositories.UserAccountDetailsRepository;

import jakarta.servlet.http.HttpSession;
@Controller
public class SendMoneyController {
	@Autowired
	public  BankAccRepository bankRepo;
	@Autowired
	public TransactionRepository txnRepo;
	@Autowired
	private UserAccountDetailsRepository walletRepo;
	@GetMapping("/sendMoney")
	public String showSendMoneyForm(HttpSession session,Model model) {
		int currentUserId=(int) session.getAttribute("userId");
		List<BankAccountEntity> fromAccounts = bankRepo.findByUserUserId(currentUserId);
		List<BankAccountEntity> toAccounts = bankRepo.findByUserUserIdNot(currentUserId);
		model.addAttribute("fromAccounts", fromAccounts);
	    model.addAttribute("toAccounts", toAccounts);
		return "sendMoney";
		
	}
	@PostMapping("/sendMoney")
	public String sendMoney(@ModelAttribute sendMoneyDto dto,HttpSession session) {
		int userId=(int) session.getAttribute("userId");
		BankAccountEntity fromAccount=bankRepo.findByAccountNumber(dto.getFromAccount());
		BankAccountEntity toAccount=bankRepo.findByAccountNumber(dto.getToAccountNumber());
		if (fromAccount == null || toAccount == null) {
	        return "error";
	    }
		if(fromAccount.getBalance()<dto.getAmount()) {
			return "insufficientFunds"; 
		}
		fromAccount.setBalance(fromAccount.getBalance() - dto.getAmount());
		toAccount.setBalance(toAccount.getBalance() + dto.getAmount());
		bankRepo.save(fromAccount);
	    bankRepo.save(toAccount);
	    TransactionEntity txn = new TransactionEntity();
	    txn.setSender(fromAccount.getUser());
	    txn.setReceiver(toAccount.getUser());
	    txn.setAmount(dto.getAmount());
	    txn.setSourceType("BANK");
	    txn.setDestinationType("BANK");
	    txn.setTransactionType("TRANSFER");
	    txn.setTxnDateTime(LocalDateTime.now());

	    txnRepo.save(txn);

	    return "redirect:/dashboard";
		
		
	}

}
