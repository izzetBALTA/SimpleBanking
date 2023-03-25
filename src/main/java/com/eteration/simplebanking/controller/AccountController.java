package com.eteration.simplebanking.controller;

// This class is a place holder you can change the complete implementation
public class AccountController {


    public Object getAccount() {
        return null;
    }
package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.services.AccountService;
import com.eteration.simplebanking.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/v1")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<Account> findAccount(@RequestBody String accountNumber) {
        return accountService.findAccount(accountNumber);
    }

    @PostMapping
    public ResponseEntity<?> saveAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.saveAccount(account));
    }

    @PatchMapping("/credit/{accountNumber}")
    public ResponseEntity<String> credit(@PathVariable String accountNumber, @RequestParam("amount") double amount) throws InsufficientBalanceException {
        return transactionService.creditProcess(accountNumber, amount);
    }

    @PatchMapping("/debit/{accountNumber}")
    public ResponseEntity<String> debit(@PathVariable String accountNumber, @RequestParam("amount") double amount) throws InsufficientBalanceException {
        return transactionService.debitProcess(accountNumber, amount);
    }

    @PostMapping("/post")
    void post(Transaction transaction) throws InsufficientBalanceException {
        transactionService.saveTransaction(transaction);
    }
}

    public Object credit( ) {
        return null;
    }
    public Object debit() {
        return null;
	}
}