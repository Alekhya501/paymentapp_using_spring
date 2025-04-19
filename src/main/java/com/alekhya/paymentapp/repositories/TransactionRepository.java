package com.alekhya.paymentapp.repositories;

import com.alekhya.paymentapp.entities.TransactionEntity;
import com.alekhya.paymentapp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
	List<TransactionEntity> findBySender(UserEntity sender);
	List<TransactionEntity> findByReceiver(UserEntity receiver);
}