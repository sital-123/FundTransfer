package com.training.FundTransfer.DTO;

import java.util.Set;

import lombok.Data;

@Data
public class BenificaryDTO {
    private Long accountNo;
    private Set<BenificaryListDTO> beneficiaryAccounts;
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public Set<BenificaryListDTO> getBeneficiaryAccounts() {
		return beneficiaryAccounts;
	}
	public void setBeneficiaryAccounts(Set<BenificaryListDTO> beneficiaryAccounts) {
		this.beneficiaryAccounts = beneficiaryAccounts;
	}

}
