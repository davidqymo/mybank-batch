package com.mybank.mybankbatch.batch;


import com.csvreader.CsvWriter;
import com.mybank.mybankbatch.entity.Customer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

@Component
public class CSVRecordWriter implements ItemWriter<Customer> {
private final File file = new File("customer.csv");
    @Override
    public void write(List<? extends Customer> custList) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
        CsvWriter cwriter = new CsvWriter(writer,',');

        for (Customer cust: custList
             ) {
            cwriter.writeRecord(cust.getCSVString());
        }
        cwriter.close();
    }

}
