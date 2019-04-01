package com.mybank.mybankbatch.batch;

import com.mybank.mybankbatch.entity.Customer;
import com.mybank.mybankbatch.repository.CustomerRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDBWriter implements ItemWriter<Customer> {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void write(List<? extends Customer> list) throws Exception {
        for (Customer cust:list
             ) {
            customerRepository.save(cust);
        }
    }
}
