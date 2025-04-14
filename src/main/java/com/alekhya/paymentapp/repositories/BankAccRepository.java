package com.alekhya.paymentapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alekhya.paymentapp.entities.BankAccountEntity;
@Repository
public interface BankAccRepository extends JpaRepository<BankAccountEntity,Integer>{
	List<BankAccountEntity> findByUserUserId(int userId);
}
