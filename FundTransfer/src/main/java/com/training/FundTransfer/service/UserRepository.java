package com.training.FundTransfer.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.FundTransfer.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByEmailAndUserName(String email, String userName);

	User findByEmailAndPassword(String email, String password);
	

}
