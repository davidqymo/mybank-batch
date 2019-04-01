package com.mybank.mybankbatch.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class AddressKey implements Serializable {
    private Long addressId;
    private Long customerid;

}
