package com.mybank.mybankbatch.batch;

import com.mybank.mybankbatch.entity.Address;
import com.mybank.mybankbatch.entity.Customer;
import com.mybank.mybankbatch.repository.AddressRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class AdressDBWriter implements ItemWriter<Customer> {

    @Autowired
    private AddressRepository addressDao;

    @Override
    public void write(List<? extends Customer> list) throws Exception {
        for (Customer cust: list
             ) {
//            System.out.println(Thread.currentThread().getName() + " preparing address for Customer ID: "+ cust.getCustomerId() +" Name: " + cust.getCustomerName());
            Address address = new Address();
            address.setCustomerid(cust.getCustomerId());
            address.setAddressDetails(
                    RandomValueUtility.getAddress().get("road").toString()
                                     );
            address.setAddressType(RandomValueUtility.getAddressType());
            addressDao.save(address);
        }
    }
}
