package com.example.activitidemo.entity.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("服务条款和隐私协议入参对象")
public class TermsContentDTO {

    @ApiModelProperty("店铺id")
    private Long id;

    @ApiModelProperty("服务条款或隐私协议内容")
    private String content;

}
