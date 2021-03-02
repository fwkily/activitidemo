package com.example.activitidemo.config;

import com.example.activitidemo.entity.City;
import com.example.activitidemo.entity.People;
import com.sun.istack.NotNull;
import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;


@Configuration
public class ActivitiConfig {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private ResourcePatternResolver resourceLoader;


    /**
     * 初始化配置，将创建28张表
     * @return
     */
    @Bean
    public StandaloneProcessEngineConfiguration processEngineConfiguration(){
        StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        configuration.setAsyncExecutorActivate(false);
        return configuration;
    }

    @Bean
    public ProcessEngine processEngine(){
        return processEngineConfiguration().buildProcessEngine();
    }

    @Bean
    public RepositoryService repositoryService(){
        return processEngine().getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService(){
        return processEngine().getRuntimeService();
    }

    @Bean
    public TaskService taskService(){
        return processEngine().getTaskService();
    }

    @Bean
    public City city(){
        City city = new City();
        city.setCityCode("2021");
        return city;
    }

    @Bean
//    @ConditionalOnBean(name = "city")
    public People people(City city){
        city.setCityName("武汉");
        People people = new People();
        people.setName("张三");
        people.setCode(123L);
        people.setCity(city);
        return people;
    }

}
