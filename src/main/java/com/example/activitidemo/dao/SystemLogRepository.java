package com.example.activitidemo.dao;

import com.example.activitidemo.entity.ClassOne;
import com.example.activitidemo.entity.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemLogRepository extends JpaRepository<SystemLog, String> {


}
