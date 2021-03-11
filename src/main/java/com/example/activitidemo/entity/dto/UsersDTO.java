package com.example.activitidemo.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UsersDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotBlank(message = "用户姓名不能为空")
    private String name;

    @NotNull
    private Integer age;

    private String address;


}
