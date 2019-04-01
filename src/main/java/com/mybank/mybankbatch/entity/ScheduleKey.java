package com.mybank.mybankbatch.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScheduleKey implements Serializable {
    private Integer scheduleId;
    private Long accountId;
}
