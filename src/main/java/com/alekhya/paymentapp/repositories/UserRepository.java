package com.alekhya.paymentapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.alekhya.paymentapp.entities.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>{
	 Optional<UserEntity> findByEmailAndPassword(String email,String password);

}
