package com.training.FundTransfer.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.FundTransfer.entities.Account;
import com.training.FundTransfer.entities.Benificiary;

@Repository
public interface BenificiaryRepository extends JpaRepository<Benificiary, Long> {


     Benificiary findByBenificaryAccount(Long benificaryAccount);

    Benificiary findByAccountNoAndBenificaryAccount(Account accountNo, Long benificaryAccount);

    Benificiary findByAccountNo(Account accountNo);
}
