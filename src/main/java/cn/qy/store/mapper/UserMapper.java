package cn.qy.store.mapper;


import cn.qy.store.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

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

    /*
     * 根据用户的uid来修改用户密码
     * @param uid 用户的id
     * @param password 用户输入的新密码
     * @param modifiedUser 表示修改的执行者
     * @param modifiedTime 表示修改数据的时间
     * @return 返回值为受影响的行数
     * */
    Integer updatePasswordByUid(@Param("uid") Integer uid, @Param("password")String password,@Param("modifiedUser") String modifiedUser, @Param("modifiedTime")Date modifiedTime);

    /*
     * 根据用户的id查询用户的数据
     * @param uid 用户的id
     * @return 如果找到则返回对象，反之返回null值
     *
     * */
    User findByUid(Integer uid);
}