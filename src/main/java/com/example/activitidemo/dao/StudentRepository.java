package com.example.activitidemo.dao;

import com.example.activitidemo.entity.Student;
import com.example.activitidemo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
