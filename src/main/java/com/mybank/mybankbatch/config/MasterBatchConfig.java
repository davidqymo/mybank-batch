package com.mybank.mybankbatch.config;

import com.mybank.mybankbatch.batch.*;
import com.mybank.mybankbatch.entity.Customer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.orm.JpaNativeQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;

import javax.persistence.EntityManagerFactory;


@Configuration
@EnableBatchProcessing
public class MasterBatchConfig {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    TaskExecutorBuilder taskExecutorBuilder;

    @Autowired
    private EntityManagerFactory emf;

    @Bean
    public AdressDBWriter adressDBWriter()
    {
        return new AdressDBWriter();
    }

    @Bean(destroyMethod = "")
    public JpaPagingItemReader<Customer> customerJpaPagingItemReader() throws Exception {
        JpaPagingItemReader<Customer> reader = new JpaPagingItemReader<Customer>();

        JpaNativeQueryProvider<Customer> queryProvider = new JpaNativeQueryProvider<Customer>();
        queryProvider.setSqlQuery( "SELECT customer_id,customer_name,email,customer_group,create_time FROM customer");
        queryProvider.setEntityClass( Customer.class );
        queryProvider.afterPropertiesSet();

        reader.setEntityManagerFactory(emf);
        reader.setPageSize(100000);
        reader.setQueryProvider( queryProvider );
        reader.afterPropertiesSet();
        return reader;
    }

    @Bean
    public ItemProcessor<Customer,Customer> getItemProcessor()
    {
        ItemProcessor<Customer,Customer> processor = custIn -> {
            Customer custOut = custIn;
//            System.out.println("Current Thread:"+Thread.currentThread().getName() +
//                               " Processing Customer ID: " + custIn.getCustomerId() +
//                                " Name: " + custOut.getCustomerName());
            return custOut;
        };
        return processor;
    }

    @Bean
    public Step genAddressStep() throws Exception {
        return stepBuilderFactory
                .get("importAddressStep")
                .<Customer,Customer>chunk(20000)
                .reader(customerJpaPagingItemReader())
                .processor(getItemProcessor())
                .writer(adressDBWriter())
                .taskExecutor( taskExecutor() )
                .throttleLimit( 50 )
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor(){
        TaskExecutor taskExecutor = taskExecutorBuilder
                .corePoolSize( 50 )
                .maxPoolSize( 100 )
                .build();
        return taskExecutor;
    }

    @Bean("importAddressJob")
    public Job getJob() throws Exception {
        return jobBuilderFactory.get("importAddressJob")
                .incrementer(new RunIdIncrementer())
                .flow(genAddressStep())
                .end()
                .build();
    }


}
