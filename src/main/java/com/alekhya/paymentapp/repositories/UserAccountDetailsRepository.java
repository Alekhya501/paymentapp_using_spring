package com.alekhya.paymentapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alekhya.paymentapp.entities.UserAccountDetailsEntity;
import com.alekhya.paymentapp.entities.UserEntity;

public interface UserAccountDetailsRepository extends JpaRepository<UserAccountDetailsEntity, Long> {
    
   
    UserAccountDetailsEntity findByUser(UserEntity user);
}