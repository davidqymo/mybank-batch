package com.mybank.mybankbatch.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Table(name = "repaymenthistory")
@IdClass(RepaymentHistoryKey.class)
@Entity
public class Repaymenthistory implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "account_id", insertable = false, nullable = false)
  private Long accountId;

  @Id
  @Column(name = "instal_duedate", insertable = false, nullable = false)
  private Date instalDuedate;

  @Column(name = "overdue_staus", nullable = false)
  private String overdueStaus;

  @Column(name = "instal_amount", nullable = false)
  private Long instalAmount;

  @Column(name = "instal_paid", nullable = false)
  private Long instalPaid;

  @Column(name = "instal_principalportion", nullable = false)
  private Long instalPrincipalportion;

  @Column(name = "instal_interestportion", nullable = false)
  private Long instalInterestportion;

  @Column(name = "instal_principal_paid", nullable = false)
  private Long instalPrincipalPaid;

  @Column(name = "instal_paiddate", nullable = false)
  private Date instalPaiddate;

  
}