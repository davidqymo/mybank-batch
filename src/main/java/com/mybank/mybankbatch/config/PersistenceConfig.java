package com.mybank.mybankbatch.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
public class PersistenceConfig {

    @Autowired
    @Qualifier("BankDS1")
    private DataSource ds;

    @Bean("entityManagerFactory")
    public EntityManagerFactory getEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(ds);
        entityManager.setPersistenceUnitName("default");
        entityManager.setJpaVendorAdapter(jpaVendorAdapter());
        entityManager.setJpaDialect(new HibernateJpaDialect());
        entityManager.setPackagesToScan("com.mybank.mybankbatch.entity");
        entityManager.afterPropertiesSet();
        System.out.println("EntityManagerFactor name: " + entityManager.getNativeEntityManagerFactory());
        return entityManager.getNativeEntityManagerFactory();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }

}