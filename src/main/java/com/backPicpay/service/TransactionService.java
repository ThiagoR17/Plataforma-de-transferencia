package com.backPicpay.service;


import com.backPicpay.DTO.TransactionDTO;
import com.backPicpay.domain.transação.Transacao;
import com.backPicpay.domain.user.User;
import com.backPicpay.repository.TransctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private UserService service;

    @Autowired
    private TransctionRepository repository;

    @Autowired
    private NotificationService notificationService;

    public Transacao createTransaction(TransactionDTO transaction) throws Exception {
        User sender = service.findUserByid(transaction.senderid());
        User receiver = service.findUserByid(transaction.receiverid());
        service.validateTransaction(sender, transaction.value());


        Transacao newTransacao = new Transacao();
        newTransacao.setAmount(transaction.value());
        newTransacao.setSender(sender);
        newTransacao.setReceiver(receiver);
        newTransacao.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        repository.save(newTransacao);
        service.saveUser(sender);
        service.saveUser(receiver);

        this.notificationService.sendNotification(sender, "Transação realizada com sucesso!");
        this.notificationService.sendNotification(receiver, "Transação recebida com sucesso!");
        return newTransacao;
    }


}

