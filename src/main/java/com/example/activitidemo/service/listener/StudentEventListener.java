package com.example.activitidemo.service.listener;

import com.example.activitidemo.entity.Student;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class StudentEventListener {

    @Async
    @EventListener(condition = "#student.id != null ")
    public void handleEvent(Student student){
        System.out.println("student是：");
        System.out.println(student.toString());
    }

}
