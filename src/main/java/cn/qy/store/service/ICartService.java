package cn.qy.store.service;

import cn.qy.store.vo.CartVO;

import java.util.List;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/30
 */
public interface ICartService {
    /**
     * 将商品添加都购物车中
     * @param uid 用户id
     * @param pid 商品id
     * @param amount 新增数量
     * @param username 用户名（修改者）
     */
    void addToCart(Integer uid, Integer pid, Integer amount, String username);

    /**
     * 获取购物车信息列表
     * @param uid 用户的id
     * @return 购物车里面的商品信息
     */
    List<CartVO> getVOByUid(Integer uid);

    /**
     * 更新用户的购物车数据的数量
     * @param cid
     * @param uid
     * @param username
     * @return 增加成功后新的数量
     */
    Integer addNum(Integer cid, Integer uid, String username);
}
