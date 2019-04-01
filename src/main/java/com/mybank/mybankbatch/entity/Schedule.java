package com.mybank.mybankbatch.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "schedule")
@IdClass(ScheduleKey.class)
@Data
public class Schedule implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(insertable = false, name = "schedule_id", nullable = false)
  private Integer scheduleId;

  @Id
  @Column(name = "account_id", insertable = false, nullable = false)
  private Long accountId;

  @Column(name = "schedule_startDate", nullable = false)
  private Date scheduleStartDate;

  @Column(name = "schedule_nextInstalDueDate", nullable = false)
  private Date scheduleNextInstalDueDate;

  @Column(name = "schedule_lastDueDate", nullable = false)
  private Date scheduleLastDueDate;

  @Column(name = "schedule_scheme", nullable = false)
  private String scheduleScheme;

  @Column(name = "schedule_intRate", nullable = false)
  private Double scheduleIntRate;

  @Column(name = "schedule_instalmentAmount", nullable = false)
  private Long scheduleInstalmentAmount;

  @Column(name = "schedule_modifytimestamp", nullable = false)
  private Date scheduleModifytimestamp;

  
}