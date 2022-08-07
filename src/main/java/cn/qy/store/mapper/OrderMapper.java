package cn.qy.store.mapper;

import cn.qy.store.entity.Order;
import cn.qy.store.entity.OrderItem;

/**
 * @description: 订单的持久层接口
 * @author: QiuYang
 * @time: 2022/7/31
 */
public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单项的数据
     * @param orderItem 订单项数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);
}
