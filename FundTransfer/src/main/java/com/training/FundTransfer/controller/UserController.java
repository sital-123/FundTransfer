package com.training.FundTransfer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.FundTransfer.DTO.UserDTO;
import com.training.FundTransfer.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signUp")
	public ResponseEntity signUpNewUser(@Valid @RequestBody UserDTO user) {
		return userService.signUpNewUser(user);
	}

	@GetMapping("/login")
	public ResponseEntity loginUser(@RequestParam(required = true, value = "email") String email,
									@RequestParam(required = true, value = "password")String password ){
		return userService.loginUser(email,password);
	}

	@GetMapping("/getall")
	public ResponseEntity getAllUsers(){
		return userService.getAllUsers();
	}

}
