package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Modifying
    @Query("update Account  set balance = balance + :amount where accountNumber < :accountNumber")
    @Transactional
    void creditBalance(@Param("accountNumber") String accountNumber, @Param("amount") Double amount);


    @Modifying
    @Query("update Account  set balance = balance - :amount where accountNumber < :accountNumber")
    @Transactional
    void debitBalance(@Param("accountNumber") String accountNumber, @Param("amount") Double amount);

}
