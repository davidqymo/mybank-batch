package com.mybank.mybankbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mybank.mybankbatch.entity.Interest;

public interface InterestRepository extends JpaRepository<Interest, Long> {

}