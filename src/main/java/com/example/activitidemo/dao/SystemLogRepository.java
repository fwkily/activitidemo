package com.example.activitidemo.dao;

import com.example.activitidemo.entity.po.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemLogRepository extends JpaRepository<SystemLog, String> {


}
