package com.alekhya.paymentapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alekhya.paymentapp.entities.UserEntity;
import com.alekhya.paymentapp.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	public void addUser(UserEntity user) {
		 userRepo.save(user);
	}
	
	public UserEntity authentication(String email,String password) {
	Optional<UserEntity> validUser=	userRepo.findByEmailAndPassword(email, password);
		if(validUser.isPresent()) {
			 return validUser.get();
		}
	
		else {
			return null;
		}
		
	}
	public UserEntity getUserById(int userId) {
		Optional<UserEntity> user = userRepo.findById(userId);
		return user.get();
	}

}
