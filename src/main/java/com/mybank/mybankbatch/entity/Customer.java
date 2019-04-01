package com.mybank.mybankbatch.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(insertable = false, name = "customer_id", nullable = false)
  private Long customerId;

  @Column(name = "customer_name", nullable = false)
  private String customerName;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "customer_group", nullable = false)
  private String customerGroup;

  @Column(name = "create_time")
  private Timestamp createTime = new Timestamp(System.currentTimeMillis());

  public String[] getCSVString()
  {
    String [] str = new String [5];
    str[0] = "0";
    str[1] = getCustomerName();
    str[2] = getEmail();
    str[3] = getCustomerGroup();
    str[4] = getCreateTime().toString();
    return str;
  }
}