package cn.qy.store.mapper;

import cn.qy.store.entity.Address;
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

public class AddressMapperTests {
    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(5);
        address.setPhone("15707008133");
        address.setName("妈妈");
        addressMapper.insert(address);

    }

    @Test
    public void countByUid() {
        Integer count = addressMapper.countByUid(5);
        System.out.println(count);
    }

    @Test
    public void findByUid() {
        List<Address> list = addressMapper.findByUid(5);
        System.out.println(list);

    }

    @Test
    public void findByAid() {
        System.err.println(addressMapper.findByAid(3));
    }

    @Test
    public void updateNonDefault() {
        addressMapper.updateNonDefault(5);
    }

    @Test
    public void updateDefaultByAid() {
        addressMapper.updateDefaultByAid(3, "管理员", new Date());
    }

    @Test
    public void deleteByAid() {
        addressMapper.deleteByAid(4);
    }

    @Test
    public void tfindLastModified() {
        System.out.println(addressMapper.findLastModified(5));
    }
}
