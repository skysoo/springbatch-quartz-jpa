package com.study.batch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Closeable;
import java.io.IOException;

@Configuration
public class DatabaseConfig implements Closeable {
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        return Persistence.createEntityManagerFactory("postgresql");
    }

    @Override
    public void close() throws IOException {
        entityManagerFactory.close();
    }
}
