package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import org.springframework.http.ResponseEntity;

public interface IAccountService {
    ResponseEntity<Account> findAccount(String accountNumber);
}
