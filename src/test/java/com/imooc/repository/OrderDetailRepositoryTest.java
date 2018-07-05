package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("15454353");
        orderDetail.setOrderId("22222");
        orderDetail.setProductId("324242");
        orderDetail.setProductIcon("http://321.png");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(5.5));
        orderDetail.setProductQuantity(434);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {

        List<OrderDetail> orderDetailList = repository.findByOrderId("11111");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}