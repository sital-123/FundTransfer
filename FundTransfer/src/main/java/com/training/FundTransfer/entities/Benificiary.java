package com.training.FundTransfer.entities;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Data
@Entity
@Table(name = "tb_beneficary")
public class Benificiary  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long benificiaryId;

	@ManyToOne
	@JoinColumn(name = "account_no",nullable = false)
	private Account accountNo;

	@Column
	private String bankname;

	private Double creditAmount;


	@Column
	private Double balance;

	@Column
	private Long benificaryAccount;

	public Long getBenificiaryId() {
		return benificiaryId;
	}

	public void setBenificiaryId(Long benificiaryId) {
		this.benificiaryId = benificiaryId;
	}

	public Account getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Account accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Long getBenificaryAccount() {
		return benificaryAccount;
	}

	public void setBenificaryAccount(Long benificaryAccount) {
		this.benificaryAccount = benificaryAccount;
	}

	
}
