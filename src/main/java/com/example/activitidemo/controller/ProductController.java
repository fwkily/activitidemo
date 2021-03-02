package com.example.activitidemo.controller;

import com.example.activitidemo.entity.ProductPO;
import com.example.activitidemo.es.entity.ProductESPO;
import com.example.activitidemo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/save")
    public ProductPO save(@RequestBody ProductPO product){
        ProductPO product1 = null;
        try {
            product1 = productService.addProduct(product);
            System.out.println("----------");
            System.out.println(product1.getReviewCount());
        }catch (Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
        }
        return product1;
    }

    @GetMapping("/queryAll")
    public List<ProductESPO> queryAll(){
        List<ProductESPO> products = productService.queryProducts();
        return products;
    }

    @GetMapping(value = "/queryByName",consumes = "application/x-www-form-urlencoded")
    public List<ProductESPO> queryByName(@RequestParam(name = "name") String name){
        List<ProductESPO> products = productService.findProductESPOSByNameContains(name);
        return products;
    }

    @DeleteMapping(value = "/delete",consumes = "application/json")
    public String delete(@RequestBody ProductESPO productESPO){
        try {
            productService.delete(productESPO);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return "删除成功";
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id){
        try {
            productService.deleteById(id);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return "删除一个id成功";
    }

    @DeleteMapping(value = "/deleteAll",consumes = "application/json")
    public String deleteAll(@RequestBody ProductESPO productESPO){
        try {
            HashSet<ProductESPO> productESPOS = new HashSet<>();
            productESPOS.add(productESPO);
            productService.deleteAll(productESPOS);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return "删除一个id成功";
    }


}
