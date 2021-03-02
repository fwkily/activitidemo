package com.example.activitidemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "system_log")
public class SystemLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String description;

    private String method;

    private Long logType;

    private String requestIp;

    private String exceptioncode;

    private String exceptionDetail;

    private String params;

    private String createBy;

    private Date createDate;

}
