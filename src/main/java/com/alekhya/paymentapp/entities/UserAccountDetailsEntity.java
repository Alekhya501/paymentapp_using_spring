package com.alekhya.paymentapp.entities;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "user_account_details")
public class UserAccountDetailsEntity {
	@Id
	@Column(name = "user_account_id")
	private Long userAccountId;
	@Column(name = "account_open_date")
	private LocalDate accountOpenDate;
	@Column(name = "current_wallet_balance")
	private double currentWalletBalance;
	@Column(name = "linked_bank_accounts_count")
	private int linkedBankAccountsCount;
	@Column(name = "wallet_pin")
	private int walletPin;
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public LocalDate getAccountOpenDate() {
		return accountOpenDate;
	}
	public void setAccountOpenDate(LocalDate accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}
	public double getCurrentWalletBalance() {
		return currentWalletBalance;
	}
	public void setCurrentWalletBalance(double currentWalletBalance) {
		this.currentWalletBalance = currentWalletBalance;
	}
	public int getLinkedBankAccountsCount() {
		return linkedBankAccountsCount;
	}
	public void setLinkedBankAccountsCount(int linkedBankAccountsCount) {
		this.linkedBankAccountsCount = linkedBankAccountsCount;
	}
	public int getWalletPin() {
		return walletPin;
	}
	public void setWalletPin(int walletPin) {
		this.walletPin = walletPin;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserAccountDetailsEntity [userAccountId=" + userAccountId + ", accountOpenDate=" + accountOpenDate
				+ ", currentWalletBalance=" + currentWalletBalance + ", linkedBankAccountsCount="
				+ linkedBankAccountsCount + ", walletPin=" + walletPin + "]";
	}
}
