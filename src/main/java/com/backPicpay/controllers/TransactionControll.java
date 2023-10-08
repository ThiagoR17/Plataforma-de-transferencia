package com.backPicpay.controllers;

import com.backPicpay.DTO.TransactionDTO;
import com.backPicpay.domain.transação.Transacao;
import com.backPicpay.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/transaction")
public class TransactionControll {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity <Transacao>createTransaction(@RequestBody TransactionDTO transaction) throws Exception{
        Transacao newTransaction = this.transactionService.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }
}
