package com.alekhya.paymentapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alekhya.paymentapp.dtos.UserRegistrationDto;
import com.alekhya.paymentapp.entities.UserEntity;
import com.alekhya.paymentapp.services.UserService;


@Controller
public class UserRegistrationController {
	
	@Autowired
	UserService userservice;
	
	@GetMapping("/register")
	public String showForm(Model model) {
		model.addAttribute("user",new UserEntity());
		return "registration";
		
	}
	
	@PostMapping("/register")
    public String registerUser(@ModelAttribute UserRegistrationDto userdto) {
	   System.out.println(userdto);
       UserEntity userentity=new UserEntity();

       userentity.setUserName(userdto.getUserName());
       userentity.setFirstName(userdto.getFirstName());
       userentity.setLastName(userdto.getLastName());
       userentity.setPhoneNumber(userdto.getPhoneNumber() );
       userentity.setAddress(userdto.getAddress());
       userentity.setEmail(userdto.getEmail());
       userentity.setPassword(userdto.getPassword());
       System.out.println(userentity);
       userservice.addUser(userentity);
        return "login"; 
    } 
	
}