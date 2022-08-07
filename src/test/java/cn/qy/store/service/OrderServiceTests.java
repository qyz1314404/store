package cn.qy.store.service;

import cn.qy.store.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: 测试持久层
 * @author: QiuYang
 * @time: 2022/6/27
 */
@SpringBootTest

public class OrderServiceTests {
    @Autowired
    private IOrderService orderService;
    @Test
    public void create(){
        Integer[] cids = {3, 4};
        orderService.create(6,5,"我",cids);

    }
}
