package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Modifying
    @Query("update Transaction u set u.amount = :amount where u.accountNumber < :accountNumber")
    @Transactional
    void credit(@Param("accountNumber") String accountNumber, @Param("amount") Double amount);

}
