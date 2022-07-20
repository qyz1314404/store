package cn.qy.store.mapper;

import cn.qy.store.entity.Address;
import cn.qy.store.entity.District;
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

public class DistrictMapperTests {
    @Autowired
    private DistrictMapper districtMapper;
    @Test
    public void findByParent(){
        List<District> list = districtMapper.findByParent("210100");
        for (District d : list) {
            System.out.println(d);
        }

    }

}
