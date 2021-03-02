package com.example.activitidemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class City implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String cityCode;

    private String cityName;

}
