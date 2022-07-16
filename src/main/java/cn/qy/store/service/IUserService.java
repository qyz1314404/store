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

    void changePassword(Integer uid, String username, String oldPassword, String newPassword);

    /*
     * 根据用户的id查询用户的数据
     * @param uid 用户id
     * @return 用户的数据
     * */
    User getByUid(Integer uid);

    /*
     * 更新用户的数据操作
     * @param uid 用户的id
     * @param username 用户的名称
     * @param user 用户对象的数据
     * */
    void changeInfo(Integer uid, String username, User user);
}
