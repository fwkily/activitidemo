package com.example.activitidemo.dao;

import com.example.activitidemo.entity.Dog;
import com.example.activitidemo.entity.po.MidpVendorConfigPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MidpVendorConfigDao extends JpaRepository<MidpVendorConfigPO, Long> {




}
