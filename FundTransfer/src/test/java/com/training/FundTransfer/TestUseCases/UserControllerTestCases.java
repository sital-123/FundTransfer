package com.training.FundTransfer.TestUseCases;

import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.training.FundTransfer.DTO.UserDTO;
import com.training.FundTransfer.entities.Account;
import com.training.FundTransfer.entities.Benificiary;
import com.training.FundTransfer.entities.User;
import com.training.FundTransfer.service.UserRepository;
import com.training.FundTransfer.service.UserService;

@DisplayName("A User Test Case for demo")
public class UserControllerTestCases {

	
	
	@Autowired
	UserService userservice;
	
	@Autowired
	 UserRepository userRepository;
	
	@BeforeEach
	public void testForEach() {
		System.out.println("testForEach method have been executed successfully...");
	}
	
	@AfterEach
	public void testAfterEach() {
		System.out.println("testAfterEach methos has been tested sucessfully...");
	}
	
	@AfterAll
	public void testAfterAll() {
		System.out.println("testAfterAll methos has been tested sucessfully...");
	}
	
	
	
   
	
	@Test
	@DisplayName("Successfull condition of User Registration")
	@Order(value = 1)
	public void registerUser() {
		User user = new User();
		user.setUserName("Sital");
		user.setEmail("sital@gmail.com");
		user.setCountry("India");
		user.setPassword("a@123");
		
		UserDTO userDto = new UserDTO();
		userDto.setBalance(25000);
		userDto.setBankName("SBI");
		userDto.setUser(user);
		
		Set <Benificiary> benificry = new HashSet<Benificiary>();
		benificry.addAll(benificry);
		
		Account account = new Account();
        account.setAccountNo((long) 1225444);
        account.setBankName("SBI");
        account.setBalance(50000);
        account.setBenificiryAccountList(null);
        account.setUser(user);
        
		when(userservice.signUpNewUser(userDto)).thenReturn(null);
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
