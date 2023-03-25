package com.eteration.simplebanking.model;


import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

// This class is a place holder you can change the complete implementation
@Getter
@Entity
@Table(name = "transaction")
public abstract class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "accountNumber")
    public String accountNumber;
    @Column(name = "date")
    private Date date;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "type")
    private String type;
    @Column(name = "approvalCode")
    @GeneratedValue
    private String approvalCode;

    @ManyToOne
    @JoinColumn(name = "account_id", insertable = true, updatable = false)
    private Account account;

    public Transaction() {

    }

    public Transaction(Double amount, String type) {
        this.date = new Date(System.currentTimeMillis());
        this.amount = amount;
        this.type= type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", amount=" + amount +
                '}';
    }
}

