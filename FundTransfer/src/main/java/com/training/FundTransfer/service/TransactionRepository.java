package com.training.FundTransfer.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.FundTransfer.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    List<Transaction> findByAccountNoAndBenificaryAccount(Long account, Long beneficaryAccount);

   // Page<Transaction> findByAccountNoContainingOrBanknameContainingOrBenificaryAccountContaining(String searchStr, String searchStr1, String searchStr2, Pageable pageable);

    Transaction findByAccountNo(Long accountNo);
}
