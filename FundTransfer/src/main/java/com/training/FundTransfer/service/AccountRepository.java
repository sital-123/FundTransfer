package com.training.FundTransfer.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.FundTransfer.entities.Account;
import com.training.FundTransfer.entities.User;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNo(Long accountNo);


    User findByUser(User user);
}
