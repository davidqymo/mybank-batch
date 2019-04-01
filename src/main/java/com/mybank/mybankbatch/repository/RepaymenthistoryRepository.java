package com.mybank.mybankbatch.repository;

import com.mybank.mybankbatch.entity.RepaymentHistoryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mybank.mybankbatch.entity.Repaymenthistory;

public interface RepaymenthistoryRepository extends JpaRepository<Repaymenthistory, RepaymentHistoryKey> {

}