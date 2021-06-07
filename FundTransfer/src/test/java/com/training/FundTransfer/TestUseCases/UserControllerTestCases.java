package com.training.FundTransfer.TestUseCases;

import static org.assertj.core.api.Assertions.anyOf;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
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
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.common.net.MediaType;
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
	
	
	
		/*
		 * @BeforeEach public void testForEach() {
		 * System.out.println("testForEach method have been executed successfully...");
		 * }
		 *//*
	 * @AfterEach public void testAfterEach() {
	 * System.out.println("testAfterEach methos has been tested sucessfully..."); }
	 */
	
	/*
	 * @AfterAll public static void testAfterAll() {
	 * System.out.println("testAfterAll methos has been tested sucessfully..."); }
	 */
	
	
	
   
	
	@Test
	@DisplayName("Positive Scenario for User Registration")
	public void registerUser() throws Exception{
		
		UserDTO userDto = new UserDTO();
		userDto.setBalance(25000);
		userDto.setBankName("SBI");
		
		User user = new User();
		user.setUserId(1L);
		user.setUserName("Sital");
		user.setEmail("sital@gmail.com");
		user.setCountry("India");
		user.setPassword("a@123");
		
		userDto.setUser(user);
		ResponseEntity<User> resEntity = new ResponseEntity<>(user,HttpStatus.OK);
		String URI = "api/user/signUp";
		Mockito.when(userservice.signUpNewUser(userDto)).thenReturn(resEntity);
		
		ResponseEntity<User> responsentity = userservice.signUpNewUser(userDto);
		assertEquals(user,userDto.getUser());
		assertEquals(responsentity.getStatusCodeValue(), HttpStatus.OK.value());
		
		}
	
	@Test
	@DisplayName("Poitive Scenario : register User ")
	public void  registermyUser() {
		UserDTO userDto = new UserDTO();
		userDto.setBalance(25000);
		userDto.setBankName("SBI");
		
		User user = new User();
		user.setUserId(1L);
		user.setUserName("Sital");
		user.setEmail("sital@gmail.com");
		user.setCountry("India");
		user.setPassword("a@123");
		
		userDto.setUser(user);
		
		//when(userservice.signUpNewUser(userDto)).thenReturn(user);
		
	}
	
	
	
	
	@Test
	@DisplayName("Sign In User : Positive Scenario")
	void LogIn() throws Exception {
		
		User user = new User();
		user.setEmail("sital.gagare523@gmail.com");
		user.setPassword("a@123");
		
		ResponseEntity<User> userone = new ResponseEntity<>(user,HttpStatus.OK);
		Mockito.when(userservice.loginUser(any(),any())).thenReturn(userone);
		
		
		User usertwo = new User();
		usertwo.setEmail("sital.gagare523@gmail.com");
		usertwo.setEmail("a@123");
		
		ResponseEntity<User> userthree = new ResponseEntity<>(usertwo,HttpStatus.OK);
		
		
		User userfour = userservice.loginUser(userthree);
		assertNotNull(userone);
		assertEquals(user.getEmail(), userfour.getEmail());
		assertEquals(user.getPassword(), userfour.getPassword());
		assertEquals(user, userfour);
	}
	
	
	
	
	
}
