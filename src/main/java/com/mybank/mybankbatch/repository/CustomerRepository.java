package com.mybank.mybankbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mybank.mybankbatch.entity.Customer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select Max(customer_id) from customer")
    public long getMaxCustomerId();

    @Query("select Min(customer_id) from customer")
    public long getMinCustomerId();
}