package com.example.activitidemo.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "class_one")
public class ClassOne implements Serializable {
 
    private static final long serialVersionUID = -15535318388014800L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String className;
 
//    @JsonIgnoreProperties(value = {"classOne"})
    @OneToMany(mappedBy = "classOne", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JsonBackReference
    @JsonIgnore
    private Set<Student> students;
 
}
 
