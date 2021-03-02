package com.example.activitidemo.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "mid_vendor_address")
public class AddressPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="midp_vendor_config_id",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private MidpVendorConfigPO midpVendorConfig;

    @Column(columnDefinition = "varchar(128) COMMENT '发货人'", nullable = false)
    private String deliveryPeople;

    @Column(columnDefinition = "varchar(32) COMMENT '所在地址（标准区域编码）'", nullable = false)
    private String areaCode;

    @Column(columnDefinition = "varchar(128) COMMENT '区域名称'", nullable = false)
    private String areaName;

    @Column(columnDefinition = "varchar(256) COMMENT '详细地址'", nullable = false)
    private String detailedAddress;

    @Column(columnDefinition = "varchar(256) COMMENT '邮箱'")
    private String email;

    @Column(columnDefinition = "varchar(128) COMMENT '手机号/固定电话'")
    private String deliveryPhone;

    @Column(columnDefinition = "int(1) COMMENT '是否为默认地址 1 是，0 否'")
    private int isDefault;

    @JsonIgnore
    public MidpVendorConfigPO getMidpVendorConfig() {
        return midpVendorConfig;
    }


}
