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

public class AddressServiceTests {
    @Autowired
    private IAddressService addressService;
    @Test
    public void addNewAddress(){
        Address address = new Address();
        address.setPhone("15907041514");
        address.setName("爸爸");
        addressService.addNewAddress(5,"管理员",address);
    }

}
