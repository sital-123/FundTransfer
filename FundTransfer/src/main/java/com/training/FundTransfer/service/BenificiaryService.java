package com.training.FundTransfer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.training.FundTransfer.DTO.BenificaryDTO;
import com.training.FundTransfer.entities.Account;
import com.training.FundTransfer.entities.Benificiary;
import com.training.FundTransfer.exception.AccountNotFoundException;

@Service
public class BenificiaryService {

    @Autowired
    BenificiaryRepository benificiaryRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TransactionRepository transactionRepository;
    public ResponseEntity addBenificary(BenificaryDTO benificaryDTO) {
        Optional<Account> account1 = Optional.fromNullable(accountRepository.findById(benificaryDTO.getAccountNo()).orElseThrow(AccountNotFoundException::new));
        if (account1.isPresent()) {
            benificaryDTO.getBeneficiaryAccounts().stream().forEach(data -> {
                Benificiary benificiary = new Benificiary();
                benificiary.setAccountNo(account1.get());
                benificiary.setBalance(data.getBalance());
                benificiary.setBankname(data.getBankName());
                benificiary.setCreditAmount(data.getCreditAmount());
                benificiary.setBenificaryAccount(data.getBenificaryAccount());
                benificiaryRepository.save(benificiary);
            });


        }
        return new ResponseEntity("Benificary account Added successfully", HttpStatus.OK);
    }


    public ResponseEntity getBenificary(Long benificaryAcc) {
        Benificiary benificaryAccount = benificiaryRepository.findByBenificaryAccount(benificaryAcc);
        if (benificaryAccount != null) {
            Map<String, Object> benificaryDetails = new HashMap<>();
            benificaryDetails.put("benificaryAccountNo", benificaryAccount.getBenificaryAccount());
            benificaryDetails.put("Balance", benificaryAccount.getBalance());
            benificaryDetails.put("BankName", benificaryAccount.getBankname());
            benificaryDetails.put("UserAccountNo", benificaryAccount.getAccountNo());
            return new ResponseEntity(benificaryDetails,HttpStatus.OK);
        } else
            throw new AccountNotFoundException();

    }
}
