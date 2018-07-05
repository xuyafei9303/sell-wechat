package com.imooc.dto;

import com.imooc.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 数据传输对象
 */
@Data
public class OrderDto {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态
     * 默认为新下单0
     */
    private Integer orderStatus;

    /**
     * 支付状态
     * 默认为0未支付
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更细时间
     */
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
