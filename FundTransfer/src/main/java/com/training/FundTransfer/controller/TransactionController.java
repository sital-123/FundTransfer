package com.training.FundTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.FundTransfer.DTO.FundTransferDTO;
import com.training.FundTransfer.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;



	
	@PostMapping("/fundtransfer")
	public ResponseEntity fundTransfer(@RequestBody FundTransferDTO fundTransferDTO) {
		return transactionService.fundTransfer(fundTransferDTO);
		
	}

	@GetMapping("/get/{accountNo}/{beneficaryAccount}")
	public ResponseEntity getTransaction(@PathVariable(name = "accountNo", required = true) Long accountNo,
										 @PathVariable(name = "beneficaryAccount", required = true) Long beneficaryAccount ){
		return transactionService.getTransaction(accountNo,beneficaryAccount);

	}}
	