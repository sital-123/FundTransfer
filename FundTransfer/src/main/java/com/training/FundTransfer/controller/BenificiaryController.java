package com.training.FundTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.FundTransfer.DTO.BenificaryDTO;
import com.training.FundTransfer.service.BenificiaryRepository;
import com.training.FundTransfer.service.BenificiaryService;

@RestController
@RequestMapping("/benificiary")
public class BenificiaryController  {

	@Autowired
	BenificiaryService benificiaryService;
	@Autowired
	BenificiaryRepository benificiaryRepository;
	
	
	@PostMapping("/add")
	ResponseEntity addBenificary(@RequestBody BenificaryDTO benificiary) {
		return benificiaryService.addBenificary(benificiary);
		
	}

	@GetMapping("get/{benificaryaccountno}")
	ResponseEntity getBenificary(@PathVariable(required = true,value = "benificaryaccountno")Long benificaryAcc){
			return benificiaryService.getBenificary(benificaryAcc);
		}



}