package com.mybank.mybankbatch.batch;

import com.mybank.mybankbatch.entity.Customer;
import com.mybank.mybankbatch.entity.ScheduleKey;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;


@Component
public class CustomerGenerator implements ItemReader<Customer> {



    @Override
    public Customer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Customer cust = new Customer();

        cust.setEmail(RandomValueUtility.getEmail(10,20));
        cust.setCustomerName(RandomValueUtility.getChineseName());
        cust.setCustomerGroup(RandomValueUtility.getCustomerGroup());
        return cust;
    }
}
