package com.mybank.mybankbatch.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "account")
public class Account implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "account_id", insertable = false, nullable = false)
  private Long accountId;

  @Column(name = "customer_id", nullable = false)
  private Long customerId;

  @Column(name = "account_status", nullable = false)
  private String accountStatus;

  @Column(name = "account_opendate", nullable = false)
  private Date accountOpendate;

  @Column(name = "account_limit", nullable = false)
  private Long accountLimit;

  @Column(name = "account_orginalLimit")
  private Long accountOrginalLimit;

  @Column(name = "account_balance", nullable = false)
  private Long accountBalance;

  @Column(name = "account_duedate", nullable = false)
  private Date accountDuedate;

  @Column(name = "account_overdue", nullable = false)
  private String accountOverdue;

  @Column(name = "account_firstODdate", nullable = false)
  private Date accountFirstODdate;

  
}