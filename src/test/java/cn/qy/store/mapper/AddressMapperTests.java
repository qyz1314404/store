package cn.qy.store.mapper;

import cn.qy.store.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description: 测试持久层
 * @author: QiuYang
 * @time: 2022/6/27
 */
@SpringBootTest

public class AddressMapperTests {
    @Autowired
    private AddressMapper addressMapper;
    @Test
    public void insert(){
        Address address = new Address();
        address.setUid(5);
        address.setPhone("15707008133");
        address.setName("妈妈");
        addressMapper.insert(address);

    }
    @Test
    public void countByUid(){
        Integer count = addressMapper.countByUid(5);
        System.out.println(count);
    }
    @Test
    public void findByUid(){
        List<Address> list = addressMapper.findByUid(5);
        System.out.println(list);

    }

}
