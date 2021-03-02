package com.example.activitidemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class People implements Serializable {

    private static final Long serialVersionUID = 1L;

    public Long code;

    public String name;

    public City city;

}
