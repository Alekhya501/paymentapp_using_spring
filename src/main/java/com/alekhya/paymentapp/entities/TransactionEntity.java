package com.alekhya.paymentapp.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "txn_id")
	private Long txnId;

	@ManyToOne
	@JoinColumn(name = "sender_id", referencedColumnName = "user_id")
	private UserEntity sender;

	@ManyToOne
	@JoinColumn(name = "receiver_id", referencedColumnName = "user_id")
	private UserEntity receiver;

	@Column(name = "source_type")
	private String sourceType; // Example: "BANK", "WALLET"

	@Column(name = "destination_type")
	private String destinationType; // Example: "BANK", "WALLET"

	@Column(name = "amount")
	private Double amount;

	@Column(name = "transaction_date")
	private LocalDateTime txnDateTime;
	@Column(name = "transaction_type")
	private String transactionType;

	// Getters and Setters

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public UserEntity getSender() {
		return sender;
	}

	public void setSender(UserEntity sender) {
		this.sender = sender;
	}

	public UserEntity getReceiver() {
		return receiver;
	}

	public void setReceiver(UserEntity receiver) {
		this.receiver = receiver;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getDestinationType() {
		return destinationType;
	}

	public void setDestinationType(String destinationType) {
		this.destinationType = destinationType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTxnDateTime() {
		return txnDateTime;
	}

	public void setTxnDateTime(LocalDateTime txnDateTime) {
		this.txnDateTime = txnDateTime;
	}
	public String getTransactionType() {
	    return transactionType;
	}

	public void setTransactionType(String transactionType) {
	    this.transactionType = transactionType;
	}
}
