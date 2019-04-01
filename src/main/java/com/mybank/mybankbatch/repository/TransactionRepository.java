package com.mybank.mybankbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mybank.mybankbatch.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}