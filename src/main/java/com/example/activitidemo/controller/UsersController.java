package com.example.activitidemo.controller;


import com.example.activitidemo.config.annotation.Log;
import com.example.activitidemo.dao.UsersRepository;
import com.example.activitidemo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Indexed
@Controller
@RequestMapping("/usersController")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @Log(operationType = "add操作:", operationName = "添加用户")
    public void testAOP(String name, Integer age){
        Users users = new Users();
        users.setName(name);
        users.setAge(age);
        usersRepository.save(users);
    }

}
