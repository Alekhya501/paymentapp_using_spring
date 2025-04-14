package com.alekhya.paymentapp.entities;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    // Link to Bank Account
    @ManyToOne
    @JoinColumn(name = "bank_account_id", referencedColumnName = "bank_account_id")
    private BankAccountEntity bankAccount;

    // Link to User (NEW)
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "transaction_type", nullable = false)
    private String transactionType; // e.g., "credit" or "debit"

    @Column(name = "description")
    private String description;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    // === Getters and Setters ===

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public BankAccountEntity getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccountEntity bankAccount) {
        this.bankAccount = bankAccount;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}