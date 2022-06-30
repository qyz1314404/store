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
}
