package cn.qy.store.service;

import cn.qy.store.entity.Order;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/31
 */
public interface IOrderService {
    Order create(Integer aid, Integer uid, String username, Integer[] cids);
}
