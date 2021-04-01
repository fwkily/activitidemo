package com.example.activitidemo.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Days implements Serializable {
    private static final long serialVersionUID = 1L;

    private String openId;
    private String daysId;
    //每天的标题
    private String title;
    //代办事项的数量
    private int itemNumber;
    //日程
    private String date;
}
