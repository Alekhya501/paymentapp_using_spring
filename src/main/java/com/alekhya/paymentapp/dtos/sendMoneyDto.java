package com.alekhya.paymentapp.dtos;

public class sendMoneyDto {
	
	    private String fromAccount;
	    private String toAccountNumber;
	    private String sendTo;
	    private String walletId;
	    private double amount;

	    // Getters and setters
	    public String getFromAccount() {
	        return fromAccount;
	    }

	    public void setFromAccount(String fromAccount) {
	        this.fromAccount = fromAccount;
	    }

	    public String getToAccountNumber() {
	        return toAccountNumber;
	    }

	    public void setToAccountNumber(String toAccountNumber) {
	        this.toAccountNumber = toAccountNumber;
	    }

	    public String getSendTo() {
	        return sendTo;
	    }

	    public void setSendTo(String sendTo) {
	        this.sendTo = sendTo;
	    }

	    public String getWalletId() {
	        return walletId;
	    }

	    public void setWalletId(String walletId) {
	        this.walletId = walletId;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }
	}



