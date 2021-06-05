package com.training.FundTransfer.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.training.FundTransfer.utility.BaseEntitySeq;

@Data
@Entity
@Table(name = "tb_transaction")
public class Transaction extends BaseEntitySeq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountID;

    @Column
    private Long accountNo;

    @Column
    private String bankname;

    @Column
    private Double balance;

    @Column
    private Long benificaryAccount;

    @Column
    private Double transferAmount;


    public Transaction() {

    }

	public Transaction(Long accountID, Long accountNo, String bankname, Double balance, Long benificaryAccount, Double transferAmount) {
		this.accountID = accountID;
		this.accountNo = accountNo;
		this.bankname = bankname;
		this.balance = balance;
		this.benificaryAccount = benificaryAccount;
		this.transferAmount = transferAmount;
	}

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
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

	public Double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}
}
