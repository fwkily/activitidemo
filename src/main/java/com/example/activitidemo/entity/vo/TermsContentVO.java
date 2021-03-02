package com.example.activitidemo.entity.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("服务条款和隐私协议出参对象")
public class TermsContentVO {

    @ApiModelProperty("店铺id")
    private Long id;

    @ApiModelProperty("服务条款或隐私协议内容")
    private String content;

}
