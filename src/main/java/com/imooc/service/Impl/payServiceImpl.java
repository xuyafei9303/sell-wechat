package com.imooc.service.Impl;

import com.imooc.dto.OrderDto;
import com.imooc.enums.PayStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import com.imooc.service.PayService;
import com.imooc.utils.JsonUtil;
import com.imooc.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.PAData;

import java.math.BigDecimal;

@Service
@Slf4j
public class payServiceImpl implements PayService {

    private static final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    @Override
    public PayResponse create(OrderDto orderDto) {

        PayRequest payRequest = new PayRequest();

        payRequest.setOpenid(orderDto.getBuyerOpenid());
        payRequest.setOrderAmount(orderDto.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDto.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);

        log.info("【微信支付】 request={}", JsonUtil.toJson(payRequest));
        PayResponse response = bestPayService.pay(payRequest);
        log.info("【微信支付】 response={}", JsonUtil.toJson(response));
        return response;
    }

    @Override
    public PayResponse notify(String notifyData) {

        // 1.验证签名

        // 2.支付的状态

        // 3.支付金额

        // 4.支付人（下单人==支付人）

        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知，payResponse={}",JsonUtil.toJson(payResponse));

        // 查询订单
        OrderDto orderDto = orderService.findOne(payResponse.getOrderId());
        if (orderDto == null) {
            log.error("【微信支付】异步通知，订单不存在，orderId={}", payResponse.getOrderId());
        }
        // 判断金额是否一致（0.10   0.1）
        if (!MathUtil.equals(payResponse.getOrderAmount(), orderDto.getOrderAmount().doubleValue())) {
            log.error("【微信支付】异步通知，订单金额不一致，orderId={}，微信通知金额={}，系统金额={}",
                    payResponse.getOrderId(),
                    payResponse.getOrderAmount(),
                    orderDto.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MENEY_VERFITY_ERROR);
        }
        // 修改订单的支付状态
        orderService.paid(orderDto);
        return payResponse;
    }
}