package com.backPicpay.repository;

import com.backPicpay.domain.transação.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransctionRepository extends JpaRepository <Transacao, Long>{
}
