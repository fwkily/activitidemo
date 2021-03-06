package com.example.activitidemo.entity.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品设置出参对象")
public class GoodsSetVO {

    @ApiModelProperty("店铺id")
    private Long id;

    @ApiModelProperty("销量展示 1 是，0 否")
    private Integer isaleShow;

    @ApiModelProperty("默认库存扣减方式 1 拍下减库存，0 付款减库存")
    private Integer inventoryDeduction;

    @ApiModelProperty("商品评价 1 开启，0 关闭")
    private Integer productEvaluation;

    @ApiModelProperty("买家交易成功后多少天评论")
    private Integer commentsDay;

    @ApiModelProperty("自动评价内容")
    private String autoEvaluation;

}
