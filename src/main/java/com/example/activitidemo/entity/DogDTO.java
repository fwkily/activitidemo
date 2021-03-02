package com.example.activitidemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class DogDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    public Long id;

    public Long code;

    public String name;

    public Integer age;


    public Integer subAge;

}
