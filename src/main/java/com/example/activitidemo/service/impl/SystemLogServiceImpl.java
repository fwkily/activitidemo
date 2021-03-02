package com.example.activitidemo.service.impl;

import com.example.activitidemo.dao.SystemLogRepository;
import com.example.activitidemo.entity.SystemLog;
import com.example.activitidemo.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "systemLogServiceImpl")
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    private SystemLogRepository systemLogRepository;

    @Override
    public SystemLog addSystemLog(SystemLog systemLog) {
        return systemLogRepository.save(systemLog);
    }
}
