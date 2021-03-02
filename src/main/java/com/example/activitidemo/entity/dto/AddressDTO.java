package com.example.activitidemo.entity.dto;


import com.example.activitidemo.entity.po.MidpVendorConfigPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("发货地址和退货地址入参对象")
public class AddressDTO {

    @ApiModelProperty("店铺id")
    private Long id;

    @NotEmpty(
            message = "缺少发货人"
    )
    @ApiModelProperty("发货人")
    private String deliveryPeople;

    @NotEmpty(
            message = "缺少所在地址（标准区域编码）"
    )
    @ApiModelProperty("'所在地址（标准区域编码）")
    private String areaCode;

    @ApiModelProperty("区域名称")
    private String areaName;

    @NotEmpty(
            message = "缺少详细地址"
    )
    @ApiModelProperty("详细地址")
    private String detailedAddress;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号/固定电话")
    private String deliveryPhone;

    @ApiModelProperty("是否为默认地址 1 是，0 否")
    private int isDefault;

    @ApiModelProperty("分页开始")
    private int page = 0;

    @ApiModelProperty("每页数据行数")
    private int pageSize = 10;

}
