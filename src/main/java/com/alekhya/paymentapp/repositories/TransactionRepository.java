package com.alekhya.paymentapp.repositories;

import com.alekhya.paymentapp.entities.TransactionEntity;
import com.alekhya.paymentapp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    List<TransactionEntity> findByUser(UserEntity user);
}