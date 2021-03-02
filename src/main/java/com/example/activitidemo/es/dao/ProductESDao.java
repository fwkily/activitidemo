package com.example.activitidemo.es.dao;

import com.example.activitidemo.es.entity.ProductESPO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductESDao extends ElasticsearchRepository<ProductESPO,Long> {

    List<ProductESPO> findProductESPOSByNameContains(String name);




}
