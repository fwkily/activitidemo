package com.example.activitidemo.entity.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("创建和修改中p店铺配置出参对象")
public class MidpVendorConfigVO {

    @ApiModelProperty("店铺id")
    public Long id;

    @ApiModelProperty("店铺名称")
    private String name;

    @ApiModelProperty("商品logo")
    private String logo;

    @ApiModelProperty("座机区号")
    private String areaNum;

    @ApiModelProperty("座机号")
    private String machineNo;

    @ApiModelProperty("客服电话号")
    private String servicePhone;

    @ApiModelProperty("店铺简介")
    private String shopDesc;

}
