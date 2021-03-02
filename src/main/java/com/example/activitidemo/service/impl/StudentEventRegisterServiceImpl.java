package com.example.activitidemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.activitidemo.entity.Student;
import com.example.activitidemo.service.StudentEventRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class StudentEventRegisterServiceImpl implements StudentEventRegisterService {

    @Autowired
    private ApplicationContext applicationEventPublisher;

    @Override
    public void reidster() {

        Student student = new Student();
        student.setId(888L);
        student.setStudentName("张三");
        applicationEventPublisher.publishEvent(student);
        System.out.println("-------序列化后----------");
        String s = JSON.toJSONString(student);
        applicationEventPublisher.publishEvent(s);
        System.out.println("-------反序列化后----------");
        Student student1 = JSON.parseObject(s,Student.class);
        applicationEventPublisher.publishEvent(student1);
        System.out.println("结束了！");
    }
}
