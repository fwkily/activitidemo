package com.example.activitidemo.dao;

import com.example.activitidemo.entity.po.ProductPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<ProductPO,Long> {


}
