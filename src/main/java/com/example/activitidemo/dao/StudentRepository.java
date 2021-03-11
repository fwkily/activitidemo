package com.example.activitidemo.dao;

import com.example.activitidemo.entity.po.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
