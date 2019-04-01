package com.mybank.mybankbatch.repository;

import com.mybank.mybankbatch.entity.AddressKey;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mybank.mybankbatch.entity.Address;

public interface AddressRepository extends JpaRepository<Address, AddressKey> {

}