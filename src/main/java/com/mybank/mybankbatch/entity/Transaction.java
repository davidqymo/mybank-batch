package com.mybank.mybankbatch.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "transaction")
@Entity
public class Transaction implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "transaction_id", insertable = false, nullable = false)
  private Long transactionId;

  @Column(name = "account_id", nullable = false)
  private Long accountId;

  @Column(name = "transaction_date", nullable = false)
  private Date transactionDate;

  @Column(name = "transaction_type", nullable = false)
  private String transactionType;

  @Column(name = "transaction_amount", nullable = false)
  private Long transactionAmount;

  @Column(name = "transaction_interest", nullable = false)
  private Long transactionInterest;

  @Column(name = "transaction_assoicateAcount", nullable = false)
  private Long transactionAssoicateAcount;

  @Column(name = "transaction_accountBalBefore", nullable = false)
  private Long transactionAccountBalBefore;

  
}