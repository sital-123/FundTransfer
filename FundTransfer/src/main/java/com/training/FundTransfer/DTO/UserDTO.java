package com.training.FundTransfer.DTO;

import com.training.FundTransfer.entities.User;

import lombok.Data;

@Data
public class UserDTO {
    private String bankName;
    private double balance;
    private User user;
    
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}