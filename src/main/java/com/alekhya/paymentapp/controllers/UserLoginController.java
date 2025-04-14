package com.alekhya.paymentapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alekhya.paymentapp.dtos.UserLoginDto;
import com.alekhya.paymentapp.entities.UserEntity;
import com.alekhya.paymentapp.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserLoginController {
	@Autowired
	UserService userService;
	@GetMapping("/authentication")
	public String validateUser(@ModelAttribute UserLoginDto loginDto,HttpSession session) {
		UserEntity loggedInUser=userService.authentication(loginDto.getEmail(), loginDto.getPassword());
		if(loggedInUser!=null) {
			session.setAttribute("email",loggedInUser.getEmail());
			session.setAttribute("userId",loggedInUser.getUserId());
			return "redirect:/dashboard";
		}
		else {
			
			return "login";
		}
		

	
	

}
}