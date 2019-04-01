package com.mybank.mybankbatch.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean("BankDS1")
    public DataSource dataSource(Environment env)
    {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("spring.datasource.hikari.jdbc-url"));
        ds.setUsername(env.getProperty("spring.datasource.hikari.username"));
        ds.setPassword(env.getProperty("spring.datasource.hikari.password"));
        ds.setDriverClassName(env.getProperty("spring.datasource.hikari.driver-class-name"));
        ds.setMaximumPoolSize( 200 );
        return ds;
    }
}
