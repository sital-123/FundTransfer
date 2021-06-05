package com.training.FundTransfer.DTO;

import lombok.Data;

@Data
public class FundTransferDTO {

    private Long accountNo;
    private Long benificaryAccount;
    private String bankName;
    private Double transferAmount;

    public FundTransferDTO(Long accountNo, Long benificaryAccount, String bankName, Double transferAmount) {
        this.accountNo = accountNo;
        this.benificaryAccount = benificaryAccount;
        this.bankName = bankName;
        this.transferAmount = transferAmount;
    }

    public FundTransferDTO() {
    }

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Long getBenificaryAccount() {
		return benificaryAccount;
	}

	public void setBenificaryAccount(Long benificaryAccount) {
		this.benificaryAccount = benificaryAccount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}

}
