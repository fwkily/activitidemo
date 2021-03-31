package com.example.activitidemo;

import com.example.activitidemo.rocketmq.controller.SR.MySink;
import com.example.activitidemo.rocketmq.controller.SR.MySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.activitidemo.dao.**"})
@EntityScan(basePackages = {"com.example.activitidemo.entity.**"})
@EnableElasticsearchRepositories(basePackages = {"com.example.activitidemo.es.**"})
@EnableBinding(value = {Source.class, Sink.class, MySource.class, MySink.class})
public class ActivitidemoApplication {

    public static void main(String[] args) {
        //解决项目整合redis而es报错问题
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(ActivitidemoApplication.class, args);
    }

}
