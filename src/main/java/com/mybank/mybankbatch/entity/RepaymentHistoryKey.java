package com.mybank.mybankbatch.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RepaymentHistoryKey implements Serializable {
    private Long accountId;
    private Date instalDuedate;
}
