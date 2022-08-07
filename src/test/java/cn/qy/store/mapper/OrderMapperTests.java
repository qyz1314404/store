package cn.qy.store.mapper;

import cn.qy.store.entity.Address;
import cn.qy.store.entity.Order;
import cn.qy.store.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @description: 测试持久层
 * @author: QiuYang
 * @time: 2022/6/27
 */
@SpringBootTest

public class OrderMapperTests {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insertOrder(){
        Order order = new Order();
        order.setUid(5);
        order.setRecvName("明明");
        order.setRecvPhone("178545648");
        orderMapper.insertOrder(order);
    }
    @Test
    public void insertOrderItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setPid(10000003);
        orderItem.setTitle("广博(GuangBo)16K115页线圈记事本子日记本文具笔记本图案随机");
        orderMapper.insertOrderItem(orderItem);
    }

}
