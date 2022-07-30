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

public class CartServiceTests {
    @Autowired
    private ICartService cartService;
    @Test
    public void addToCart(){
            cartService.addToCart(5,10000011,10,"管理员");
    }
}
