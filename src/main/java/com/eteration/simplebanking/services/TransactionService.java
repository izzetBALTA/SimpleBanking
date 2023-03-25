package com.eteration.simplebanking.services;


import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    public Boolean saveTransaction(Transaction transaction) throws InsufficientBalanceException {
        try {
            transactionRepository.save(transaction);
        } catch (Exception ex) {
            throw new InsufficientBalanceException("Error while saving transaction!");
        }
        return true;
    }

    public ResponseEntity<String> creditProcess(String accountNumber, Double amount) throws InsufficientBalanceException {
        try {
            transactionRepository.credit(String.valueOf(accountNumber), amount);
            accountRepository.creditBalance(String.valueOf(accountNumber), amount);

        } catch (Exception ex) {
            throw new InsufficientBalanceException("Error while credit! " + ex);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


    public ResponseEntity<String> debitProcess(String accountNumber, Double amount) throws InsufficientBalanceException {
        try {
            transactionRepository.credit(String.valueOf(accountNumber), amount);
            accountRepository.debitBalance(String.valueOf(accountNumber), amount);

        } catch (Exception ex) {
            throw new InsufficientBalanceException("Error while debit !");
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


}
