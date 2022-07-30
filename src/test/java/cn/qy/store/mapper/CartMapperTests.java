package cn.qy.store.mapper;

import cn.qy.store.entity.Address;
import cn.qy.store.entity.Cart;
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

public class CartMapperTests {
    @Autowired
    private CartMapper cartMapper;
    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(5);
        cart.setPid(10000011);
        cart.setNum(2);
        cart.setPrice(1000L);
        cartMapper.insert(cart);
    }
    @Test
    public void updateNumByCid(){
        cartMapper.updateNumByCid(1,4,"管理员",new Date());

    }
   @Test
    public void findByUidAndPid(){
       Cart cart = cartMapper.findByUidAndPid(5, 10000011);
       System.err.println(cart);

   }

}
