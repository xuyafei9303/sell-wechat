package com.imooc.service;

import com.imooc.dto.OrderDto;

/**
 * 消息推送
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDto
     */
    void orderStatus(OrderDto orderDto);
}
