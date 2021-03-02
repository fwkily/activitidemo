package com.example.activitidemo.controller;

import com.example.activitidemo.service.StudentEventRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventListenerController {

    @Autowired
    private StudentEventRegisterService studentEventRegisterService;

    @GetMapping("/registStudent")
    public void register(){
        try {
            studentEventRegisterService.reidster();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
