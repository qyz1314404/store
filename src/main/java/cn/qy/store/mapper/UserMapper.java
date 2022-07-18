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

    /*
     * 更新用户的数据信息
     * @param user 用户的数据
     * @return 返回值为受影响的行数
     * */
    Integer updateInfoByUid(User user);

    /*
    * 注解@Param("这里写SQL映射文件中占位符的变量名")：解决的问题，当SQL语句的占位符和映射的
    * 接口方法参数名不一致时，需要将某个参数强行注入到某个占位符变量上时，可以使用@param这个
    * 注解来标明映射的关系。
    *
    * 根据用户uid值来修改用户的头像
    * @param uid
    * @param avatar
    * @param modifiedUser
    * @param modifiedTime
    * @return
    * */
    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);







}