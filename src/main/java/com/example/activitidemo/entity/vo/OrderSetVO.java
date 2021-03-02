package com.example.activitidemo.entity.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("订单设置入参对象")
public class OrderSetVO {

    @ApiModelProperty("店铺id")
    private Long id;
    @ApiModelProperty("未支付订单多少小时后自动关闭")
    private Integer unpaidTime;

    @ApiModelProperty("已发货订单多少天后自动确认收货")
    private Integer shippedOrderDays;

    @ApiModelProperty("已收货订单多少天后关闭退款/退货功能")
    private Integer orderReceivedDays;

    @ApiModelProperty("买家发起退款申请多少天后商家未处理，系统将自动同意退款")
    private Integer refundUntreatedDays;

    @ApiModelProperty("买家发起退货退款申请多少天后商家未处理，系统将自动同意售后")
    private Integer refundsDays;

    @ApiModelProperty("商家同意退货多少天后买家未处理，系统将自动取消售后")
    private Integer agreeToReturn;

    @ApiModelProperty("买家已退货多少天后商家未处理，系统将自动同意/拒绝退款/确认收货")
    private Integer haveReturn;

}
