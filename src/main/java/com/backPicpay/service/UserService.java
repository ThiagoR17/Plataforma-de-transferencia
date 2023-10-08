package com.backPicpay.service;

import com.backPicpay.DTO.UserDTO;
import com.backPicpay.domain.user.User;
import com.backPicpay.domain.user.UserType;
import com.backPicpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuario do tipo lojista não realiza transação!");
        }

        if(sender.getBalance().compareTo(amount) < 0 ){
            throw new Exception("Saldo insuficiente ");

        }
    }

    public User findUserByid(Long id) throws Exception{
        return this.repository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));

    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;

    }

    public void saveUser(User user){
        this.repository.save(user);
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }
}
