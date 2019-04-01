package com.mybank.mybankbatch.batch;

import com.mybank.mybankbatch.entity.Customer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.validation.BindException;
import java.sql.Timestamp;

@Configuration
public class FlatFileItemReaderConfig {

    @Value("customer.csv")
    private Resource resource;


    @Bean("customerCVSReader")
    public FlatFileItemReader<Customer> getCustomerCVSReader() {
        FlatFileItemReader<Customer> reader = new FlatFileItemReader<Customer>();
        reader.setLineMapper(lineMapper());
        reader.setResource(resource);
        return reader;
    }

    @Bean("customerLineMapper")
    public LineMapper<Customer> lineMapper()
    {
        DefaultLineMapper lineMapper = new DefaultLineMapper();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setNames("customerId","customerName","email","customer_group","create_time");
        FieldSetMapper<Customer> fieldSetMapper = new FieldSetMapper<Customer>() {
            @Override
            public Customer mapFieldSet(FieldSet fieldSet) throws BindException {
                Customer cust = new Customer();
                cust.setCustomerId(null);
                cust.setCustomerName(fieldSet.readString("customerName"));
                cust.setEmail(fieldSet.readString("email"));
                cust.setCustomerGroup(fieldSet.readString("customer_group"));
                cust.setCreateTime(new Timestamp(fieldSet.readDate("create_time").getTime()));
                return cust;
            }
        };
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }
}
