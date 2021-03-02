package com.example.activitidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.activitidemo.dao.**"})
@EntityScan(basePackages = {"com.example.activitidemo.entity.**"})
@EnableElasticsearchRepositories(basePackages = {"com.example.activitidemo.es.**"})
public class ActivitidemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitidemoApplication.class, args);
    }

}
