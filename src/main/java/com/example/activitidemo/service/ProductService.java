package com.example.activitidemo.service;


import com.example.activitidemo.entity.ProductPO;
import com.example.activitidemo.es.entity.ProductESPO;

import java.util.List;
import java.util.Set;

public interface ProductService {

    ProductPO addProduct(ProductPO product);

    List<ProductESPO> queryProducts();

    List<ProductESPO> findProductESPOSByNameContains(String name);

    void delete(ProductESPO productESPO);

    void deleteById(Long id);

    void deleteAll(Set<ProductESPO> ids);

}
