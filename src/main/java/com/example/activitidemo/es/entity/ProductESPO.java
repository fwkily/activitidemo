package com.example.activitidemo.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Document(indexName = "productindex",type = "product")
public class ProductESPO implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    Long id;

    //如果既没有指明 关联到哪个Column,又没有明确要用@Transient忽略，那么就会自动关联到表对应的同名字段
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Long)
    private BigDecimal originalPrice;
    @Field(type = FieldType.Long)
    private Integer stock;
    @Field(type = FieldType.Long)
    private Date createDate;
    @Field(type = FieldType.Long)
    private Integer reviewCount;

}

