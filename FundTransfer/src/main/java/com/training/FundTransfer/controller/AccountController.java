package com.training.FundTransfer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.training.FundTransfer.service.AccountService;



@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;



	
	
	
	
}