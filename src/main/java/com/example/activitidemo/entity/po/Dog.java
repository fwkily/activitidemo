package com.example.activitidemo.entity.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Entity
@Table(name = "dog")
public class Dog implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    public Long id;

    @Getter
    @Setter
    public Long code;

    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public Integer age;

//    @Getter
//    @Setter
//    public Integer subAge;



}
