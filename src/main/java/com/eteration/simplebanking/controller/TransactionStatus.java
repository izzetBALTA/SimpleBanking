package com.eteration.simplebanking.controller;


// This class is a place holder you can change the complete implementation

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TransactionStatus extends ResponseEntity {

    public TransactionStatus( HttpStatus status) {
        super(status);
    }


}

