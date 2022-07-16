package cn.qy.store.service;

import cn.qy.store.entity.User;
import cn.qy.store.mapper.UserMapper;
import cn.qy.store.service.ex.ServiceException;
import cn.qy.store.service.ex.UpdateException;
import cn.qy.store.service.ex.UserNotFoundException;
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

public class UserServiceTests {
    @Autowired
    private IUserService userService;

    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("yuanxin02");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("ok");
        } catch (ServiceException e) {
            // 获取类的对象，再获取类的名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常的具体描述信息
            System.out.println(e.getMessage());

        }

    }

    @Test
    public void login() {
        try {
            User user = userService.login("test01", "1234");
            System.out.println(user);
        } catch (ServiceException e) {
            // 获取类的对象，再获取类的名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void changePassword() {
        userService.changePassword(5,"管理员","123456","123");
    }
    @Test
    public void getByUid() {
        System.err.println(userService.getByUid(5));
    }
@Test
    public void changeInfo() {
    User user = new User();
    user.setPhone("15907041514");
    user.setEmail("qiu@qq.com");
    user.setGender(0);
    userService.changeInfo(5,"管理员",user);
}
}
