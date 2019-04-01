package com.mybank.mybankbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mybank.mybankbatch.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}