package com.imooc.service;

import com.imooc.dto.OrderDto;
import com.lly835.bestpay.model.PayResponse;

public interface PayService {

    PayResponse create(OrderDto orderDto);

    PayResponse notify(String notifyData);
}
