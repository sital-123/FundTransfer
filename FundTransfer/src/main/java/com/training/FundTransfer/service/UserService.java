package com.training.FundTransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.FundTransfer.DTO.UserDTO;
import com.training.FundTransfer.entities.Account;
import com.training.FundTransfer.entities.LoginStatus;
import com.training.FundTransfer.entities.User;
import com.training.FundTransfer.exception.EmailAndUserNameValidationException;
import com.training.FundTransfer.exception.UserNotFoundException;

import javax.validation.Valid;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    public ResponseEntity signUpNewUser(UserDTO user) throws EmailAndUserNameValidationException {
        if (StringUtils.isNotBlank(user.getUser().getEmail())) {
            User newUser = userRepository.findOneByEmailAndUserName(user.getUser().getEmail(), user.getUser().getUserName());
            if (newUser != null) {
                if (newUser.getEmail().equals(user.getUser().getEmail()) || newUser.getUserName().equals(user.getUser().getUserName()))
                    throw new EmailAndUserNameValidationException();
            }
            User userDetails = new User();
            userDetails.setEmail(user.getUser().getEmail());
            userDetails.setCountry(user.getUser().getCountry());
            userDetails.setPassword(user.getUser().getPassword());
            userDetails.setUserName(user.getUser().getUserName());
            Account account = new Account();
            account.setBalance(user.getBalance());
            account.setBankName(user.getBankName());
            userDetails.setAccount(account);
            account.setUser(userDetails);
            userRepository.save(userDetails);
        }
        return new ResponseEntity<>("user Successfully Register", HttpStatus.OK);
    }

	public ResponseEntity loginUser(String email, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmailAndPassword(email, password);
		if(user == null) {
			throw new UserNotFoundException();
		}
		else if(user.getEmail().equals(email) && password.equals(user.getPassword())) {
			user.setLoginStatus(LoginStatus.Success);
			userRepository.save(user);
			
		}
		return new ResponseEntity<>("User Login Successfully", HttpStatus.OK);
		
		
	}

	public ResponseEntity getAllUsers() {
		// TODO Auto-generated method stub
		return (ResponseEntity) userRepository.findAll();
	}

	public User loginUser(ResponseEntity<User> userthree) {
		// TODO Auto-generated method stub
		return null;
	}}
