package com.example.activitidemo.entity.po;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "midp_vendor_config", indexes = {
        @Index(name="MIDP_VENDOR_CONFIG_ORGCODE",columnList = "orgCode")
})
public class MidpVendorConfigPO implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(columnDefinition = "varchar(128) COMMENT '店铺的组织编码'",nullable = false)
    private String orgCode;

    @Column(name = "`name`",columnDefinition = "varchar(128) COMMENT '店铺名称'",nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(512) COMMENT '商品列表展示图，需要在已上传图片images参数中选择'")
    private String logo;

    @Column(columnDefinition = "varchar(128) COMMENT '座机区号'")
    private String areaNum;

    @Column(columnDefinition = "varchar(128) COMMENT '座机号'")
    private String machineNo;

    @Column(columnDefinition = "varchar(128) COMMENT '客服电话号'")
    private String servicePhone;

    @Column(columnDefinition = "varchar(512) COMMENT '店铺简介'")
    private String shopDesc;

    @OrderBy("id desc")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "midpVendorConfig")
    private List<AddressPO> addressPOList;

    @Column(columnDefinition = "TEXT COMMENT '服务条款'")
    private String servicePolicy;

    @Column(columnDefinition = "TEXT COMMENT '隐私协议'")
    private String privacyPolicy;

    @Column(columnDefinition = "TEXT COMMENT '关于我们'")
    private String aboutUs;

    //----------------------------------------------------------------------

    @Column(columnDefinition = "int(1) COMMENT '销量展示 1 是，0 否'")
    private Integer isaleShow;

    @Column(columnDefinition = "int(1) COMMENT '默认库存扣减方式 1 拍下减库存，0 付款减库存'")
    private Integer inventoryDeduction;

    @Column(columnDefinition = "int(1) COMMENT '商品评价 1 开启，0 关闭'")
    private Integer productEvaluation;

    @Column(columnDefinition = "int(4) COMMENT '买家交易成功后多少天评论'")
    private Integer commentsDay;

    @Column(columnDefinition = "varchar(512) COMMENT '自动评价内容'")
    private String autoEvaluation;

    //----------------------------------------------------------------------

    @Column(columnDefinition = "int(4) COMMENT '未支付订单多少小时后自动关闭'")
    private Integer unpaidTime;

    @Column(columnDefinition = "int(4) COMMENT '已发货订单多少天后自动确认收货'")
    private Integer shippedOrderDays;

    @Column(columnDefinition = "int(4) COMMENT '已收货订单多少天后关闭退款/退货功能'")
    private Integer orderReceivedDays;

    @Column(columnDefinition = "int(4) COMMENT '买家发起退款申请多少天后商家未处理，系统将自动同意退款'")
    private Integer refundUntreatedDays;

    @Column(columnDefinition = "int(4) COMMENT '买家发起退货退款申请多少天后商家未处理，系统将自动同意售后'")
    private Integer refundsDays;

    @Column(columnDefinition = "int(4) COMMENT '商家同意退货多少天后买家未处理，系统将自动取消售后'")
    private Integer agreeToReturn;

    @Column(columnDefinition = "int(4) COMMENT '买家已退货多少天后商家未处理，系统将自动同意/拒绝退款/确认收货'")
    private Integer haveReturn;

    @CreatedDate
    @Column(nullable = false)
    private Timestamp createTime;

    @LastModifiedDate
    private Timestamp lastUpdateTime;



}
