package cn.qy.store.service;

import cn.qy.store.entity.User;

/**
 * @description: 用户模块业务层接口
 * @author: QiuYang
 * @time: 2022/6/29
 */
public interface IUserService {
    /*
     * @param user 用户的数据对象
     * */
    void reg(User user);

    /*
     * 用户登录功能
     * @param username 用户名
     * @param password 用户的密码
     * @return 当前匹配的用户数据，如果没有则返回null值
     *
     * */
    User login(String username, String password);
}
