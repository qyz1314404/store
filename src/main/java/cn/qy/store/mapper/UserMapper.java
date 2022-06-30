package cn.qy.store.mapper;


import cn.qy.store.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @description: 用户模块的持久层接口
 * @author: QiuYang
 * @time: 2022/6/26
 */
@Repository
public interface UserMapper {
    /*
    * 插入用户数据
    * */
    Integer insert(User user);

    /*
     * 根据用户名来查询用户的数据
     * */
    User findByUsername(String username);
}
