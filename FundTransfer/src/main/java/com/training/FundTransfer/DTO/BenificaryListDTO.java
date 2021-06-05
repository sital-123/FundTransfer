package com.training.FundTransfer.DTO;

import lombok.Data;

@Data
public class BenificaryListDTO {
    private String bankName;

    private Double creditAmount;

    private Double balance;

    private Long benificaryAccount;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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
