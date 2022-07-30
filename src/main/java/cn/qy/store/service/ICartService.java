package cn.qy.store.service;

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
}
