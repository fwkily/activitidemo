package com.example.activitidemo.controller;


import com.example.activitidemo.config.annotation.Log;
import com.example.activitidemo.dao.UsersRepository;
import com.example.activitidemo.entity.dto.UsersDTO;
import com.example.activitidemo.entity.po.Users;
import com.example.activitidemo.utils.returnMode.ResultModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Indexed
@RestController
@RequestMapping("/usersController")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @ResponseBody
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @Log(operationType = "add操作:", operationName = "添加用户")
    public ResultModel<String> testAOP(@RequestBody @Validated UsersDTO usersDTO){
        ResultModel<String> resultModel = new ResultModel<>();
//        if(bindingResult.hasErrors()){
//            List<ObjectError> errors = bindingResult.getAllErrors();
//            List<String> strings = errors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
//            errors.stream().forEach(it -> {
//                System.out.println(it.getDefaultMessage());
//
//
//            });
//            resultModel.fail(strings.toString());
//            return resultModel;
//        }
        Users users = new Users();
        BeanUtils.copyProperties(usersDTO,users);
        Users users1 = usersRepository.save(users);
        resultModel.setMessage("新增成功,Id为：" + users1.getId());
        return resultModel;
    }

}
