package com.imooc.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填项")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填项")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "买家地址必填项")
    private String address;

    /**
     * 买家微信openid
     */
    @NotEmpty(message = "买家微信openid必填项")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车必填项")
    private String items;
}
