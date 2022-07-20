package cn.qy.store.service;

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

public class DistrictServiceTests {
    @Autowired
    private IDistrictService districtService;

    @Test
    public void getByParent() {
        //86表示中国，所有省的父代号都是86
        List<District> list = districtService.getByParent("86");
        for (District d : list) {
            System.err.println(d);
        }
    }

}
