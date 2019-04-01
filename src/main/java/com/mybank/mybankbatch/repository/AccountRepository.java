package com.mybank.mybankbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mybank.mybankbatch.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}