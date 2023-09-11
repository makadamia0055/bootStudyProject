package com.bootproject.bootproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
public class JpaConfig {



    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){return new PersistenceExceptionTranslationPostProcessor();}

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){return new HibernateJpaVendorAdapter();}

    //EntityManagerFactory도 자동으로 빈 등록 및 관리 해준다고 함.
}
