package cn.qy.store.mapper;

import cn.qy.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @description: 测试持久层
 * @author: QiuYang
 * @time: 2022/6/27
 */
@SpringBootTest

public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);

    }
@Test
    public void updatePasswordByUid() {
    userMapper.updatePasswordByUid(7, "123", "管理员",new Date());
    }
@Test
    public void findByUid() {
    System.out.println(userMapper.findByUid(1));
}
@Test
    public void updateInfoByUid(){
    User user = new User();
    user.setUid(5);
    user.setPhone("18307043228");
    user.setEmail("tom01@qq.com");
    user.setGender(1);
    userMapper.updateInfoByUid(user);
}
}
