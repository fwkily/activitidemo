package com.example.activitidemo.utils.returnMode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Api(
    value = "统一返回模型",
    tags = {"统一返回模型"}
)
@Data
public class ResultModel<T> implements Serializable, SpecialCacheEntity {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("响应信息")
    private String message;
    @ApiModelProperty("响应状态码 0-正常 其他-异常 500X业务异常 403 没有权限 401 token异常")
    private int subCode = 0;
    @ApiModelProperty("响应实体类")
    private T data;
    @ApiModelProperty("分页信息")
    private MsgPageInfo pageInfo;


    public ResultModel() {
        this.message = "success";
    }

    public ResultModel(T data) {
        this.data = data;
        this.message = "success";
    }

    public ResultModel(String message) {
        this.message = message;
    }

    public ResultModel(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public ResultModel(int subCode, String message) {
        this.subCode = subCode;
        this.message = message;
    }

    public ResultModel(T data, int subCode, String message) {
        this.data = data;
        this.subCode = subCode;
        this.message = message;
    }

    public void setData(T data, MsgPageInfo pageInfo) {
        this.data = data;
        this.pageInfo = pageInfo;
    }

    public ResultModel<T> success() {
        this.setSubCode(0);
        this.setMessage("success");
        return this;
    }

    public ResultModel<T> success(T object) {
        this.setData(object);
        this.setSubCode(0);
        this.setMessage("success");
        return this;
    }

    public ResultModel<T> fail() {
        this.setSubCode(500);
        this.setMessage("fail");
        return this;
    }

    public ResultModel<T> fail(String errMsg) {
        this.setSubCode(500);
        this.setMessage(errMsg);
        return this;
    }


    @Override
    public boolean isCache() {
        return this.subCode == 0;
    }
}
