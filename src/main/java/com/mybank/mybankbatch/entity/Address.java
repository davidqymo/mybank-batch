package com.mybank.mybankbatch.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Table(name = "address")
@Data
@Entity
public class Address implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(insertable = false, name = "address_id", nullable = false)
  private long addressId;


  @Column(name = "customerid", nullable = false)
  private Long customerid;

  @Column(name = "address_type", nullable = false)
  private String addressType;

  @Column(name = "address_details", nullable = false)
  private String addressDetails;

  
}