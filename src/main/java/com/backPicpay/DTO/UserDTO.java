package com.backPicpay.DTO;

import com.backPicpay.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String nome, String sobreNome, String documento, BigDecimal balance, String email, UserType userType){
}
