package com.mybank.mybankbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@EnableBatchProcessing
@Configuration
public class AccountImportJobConfig {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    TaskExecutorBuilder taskExecutorBuilder;

    @Autowired
    private EntityManagerFactory emf;

    public Job importAccountJob()
    {
    return jobBuilderFactory.get( "RamdomAccountGeneration" )
    }

}
