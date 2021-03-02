package com.example.activitidemo.entity.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("创建和修改中p店铺配置入参对象")
public class MidpVendorConfigDTO {

    @ApiModelProperty("店铺id")
    public Long id;

    @NotEmpty(
            message = "缺少店铺名称"
    )
    @ApiModelProperty("店铺名称")
    private String name;

    @NotEmpty(
            message = "缺少商品logo"
    )
    @ApiModelProperty("商品logo")
    private String logo;

    @NotEmpty(
            message = "缺少座机区号"
    )
    @ApiModelProperty("座机区号")
    private String areaNum;

    @NotEmpty(
            message = "缺少座机号"
    )
    @ApiModelProperty("座机号")
    private String machineNo;

    @NotEmpty(
            message = "缺少客服电话号"
    )
    @ApiModelProperty("客服电话号")
    private String servicePhone;

    @ApiModelProperty("店铺简介")
    private String shopDesc;

}
