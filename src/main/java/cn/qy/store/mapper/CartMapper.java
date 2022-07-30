package cn.qy.store.mapper;

import cn.qy.store.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @description: 加入购物车持久层
 * @author: QiuYang
 * @time: 2022/7/29
 */
public interface CartMapper {
    /**
     * @Author QiuYang
     * @Description  插入购物车数据
     * @Param cart 购物车数据
     * @return 受影响的行数
     * @Date  2022/7/29 21:57
     **/
    Integer insert(Cart cart);
/**
 * @Author QiuYang
 * @Description  更新购物车某件商品的数量
 * @Param cid 购物车数据id
 * @Param num 更新的数量
 * @Param modifiedUser 修改者
 * @Param modifiedTime 修改时间
 * @return 受影响的行数
 * @Date  2022/7/29 22:03
 **/
    Integer updateNumByCid(@Param("cid") Integer cid, @Param("num")Integer num,@Param("modifiedUser") String modifiedUser, @Param("modifiedTime")Date modifiedTime);
/**
 * @Author QiuYang
 * @Description  根据用户的id和商品的id来查询购物车中的数据
 * @Param uid 用户id
 * @Param pid 商品id
 * @return 返回数据
 * @Date  2022/7/29 22:10
 **/
    Cart findByUidAndPid(@Param("uid") Integer uid,@Param("pid") Integer pid);
}
