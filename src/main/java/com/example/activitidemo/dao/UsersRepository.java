package com.example.activitidemo.dao;

import com.example.activitidemo.entity.po.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {


}
