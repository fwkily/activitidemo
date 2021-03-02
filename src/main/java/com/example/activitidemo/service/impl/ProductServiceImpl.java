package com.example.activitidemo.service.impl;

import com.example.activitidemo.dao.ProductDao;
import com.example.activitidemo.entity.ProductPO;
import com.example.activitidemo.es.dao.ProductESDao;
import com.example.activitidemo.es.entity.ProductESPO;
import com.example.activitidemo.exception.BusiEnum;
import com.example.activitidemo.exception.BusiException;
import com.example.activitidemo.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductESDao productESDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public ProductPO addProduct(ProductPO product) {
        ProductPO product1 = productDao.save(product);
        ProductESPO productESPO = new ProductESPO();
        BeanUtils.copyProperties(product1,productESPO,"reviewCount");
        productESPO.setReviewCount(product.getReviewCount());
        if(product1.getId() != null){
            ProductESPO product2 = productESDao.save(productESPO);
            if(product2 == null){
                throw new BusiException(BusiEnum.FAILE);
            }
        }
        return product1;
    }

    @Override
    public List<ProductESPO> queryProducts() {
        return initES();
    }

    @Override
    public List<ProductESPO> findProductESPOSByNameContains(String name) {
        return productESDao.findProductESPOSByNameContains(name);
    }

    @Override
    public void delete(ProductESPO productESPO) {
        productESDao.delete(productESPO);
    }

    @Override
    public void deleteById(Long id) {
        productESDao.deleteById(id);
    }

    @Override
    public void deleteAll(Set<ProductESPO> productESPOSet) {
        productESDao.deleteAll(productESPOSet);

    }

    public List<ProductESPO> initES(){
        List<ProductESPO> products = new ArrayList<>();
        Iterable<ProductESPO> productESDaoAll = productESDao.findAll();
        if(!productESDaoAll.iterator().hasNext()){
            ProductESPO productESPO = productESDaoAll.iterator().next();
            ProductPO productPO = new ProductPO();
            BeanUtils.copyProperties(productESPO,productPO);
            productDao.save(productPO);
        }
        productESDaoAll.forEach(product -> products.add(product));
        return products;
//        ArrayList<Product> list = Lists.newArrayList(productESDaoAll);
    }


}
