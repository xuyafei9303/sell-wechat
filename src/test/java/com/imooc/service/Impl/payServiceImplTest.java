package com.imooc.service.Impl;

import com.imooc.dto.OrderDto;
import com.imooc.service.OrderService;
import com.imooc.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class payServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {

        OrderDto orderDto = orderService.findOne("1530778347284207439");
        payService.create(orderDto);
    }

    @Test
    public void refund() {

        OrderDto orderDto = orderService.findOne("1530778347284207439");
        payService.refund(orderDto);
    }
}