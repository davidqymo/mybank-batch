package com.mybank.mybankbatch.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "interest")
public class Interest implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "account_id", insertable = false, nullable = false)
  private Long accountId;

  @Column(name = "int_enddate", nullable = false)
  private Date intEnddate;

  @Column(name = "int_lastCalDate", nullable = false)
  private Date intLastCalDate;

  @Column(name = "int_balanceBase", nullable = false)
  private Long intBalanceBase;

  @Column(name = "int_rate", nullable = false)
  private Double intRate;

  @Column(name = "int_accrued", nullable = false)
  private Long intAccrued;

  @Column(name = "int_collected", nullable = false)
  private Long intCollected;

  @Column(name = "int_odIntAccrued", nullable = false)
  private Long intOdIntAccrued;

  @Column(name = "int_odIntCollected", nullable = false)
  private Long intOdIntCollected;

  @Column(name = "int_odrate", nullable = false)
  private Double intOdrate;

  @Column(name = "int_modifyTimeStamp", nullable = false)
  private Date intModifyTimeStamp;

  
}