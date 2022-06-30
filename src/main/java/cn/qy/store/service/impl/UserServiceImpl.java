package cn.qy.store.service.impl;

import cn.qy.store.entity.User;
import cn.qy.store.mapper.UserMapper;
import cn.qy.store.service.IUserService;
import cn.qy.store.service.ex.InsertException;
import cn.qy.store.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @description: 用户模块业务层的实现类
 * @author: QiuYang
 * @time: 2022/6/29
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
        // 通过user参数来获取传递过来的username
        String username = user.getUsername();
        // 调用findByUsername（username）判断用户是否被注册过
        User result = userMapper.findByUsername(username);
        // 判断结果集是否不为null则抛出用户名被占用的异常
        if (result != null) {
            throw new UsernameDuplicatedException("用户名被占用");
        }
        //密码加密处理的实现：md5算法的形式:67dh-ufaios-256
        //(串+password+串）---md5算法进行加密，连续加载三次
        //盐值+password+盐值 -----盐值就是一个随机的字符串
        String oldPassword = user.getPassword();
        //获取盐值（随机生成一个盐值）
        String salt = UUID.randomUUID().toString().toUpperCase();
        // 补全数据：盐值的记录
        user.setSalt(salt);
        //将密码和盐值作为一个整体进行加密处理,忽略原有密码强度提升了数据的安全性
        String md5Password = getMD5Password(oldPassword, salt);
        //将加密之后的密码重新补全设置到user对象中
        user.setPassword(md5Password);

        //补全数据: is_delete设置成0
        user.setIsDelete(0);
        //补全数据:4个日志字段信息
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        //执行注册业务功能的实现
        Integer rows = userMapper.insert(user);
        //如果在插入时，服务器发生宕机，抛出异常。
        if (rows != 1) {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    private String getMD5Password(String password, String salt) {
        for (int i = 0; i < 3; i++) {
            //md5加密算法方法的调用（进行三次加密）
             password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        //返回加密之后的密码
        return password;
    }
}
