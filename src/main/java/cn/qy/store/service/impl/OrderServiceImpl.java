package cn.qy.store.service.impl;

import cn.qy.store.entity.Address;
import cn.qy.store.entity.Order;
import cn.qy.store.entity.OrderItem;
import cn.qy.store.mapper.OrderMapper;
import cn.qy.store.service.IAddressService;
import cn.qy.store.service.ICartService;
import cn.qy.store.service.IOrderService;
import cn.qy.store.service.ex.InsertException;
import cn.qy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/31
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ICartService cartService;
    @Override
    public Order create(Integer aid, Integer uid, String username, Integer[] cids) {
        List<CartVO> list = cartService.getVOByCid(uid, cids);
        // 计算产品的总价
        Long totalPrice = 0L;
        for (CartVO cartVO : list) {
            totalPrice += cartVO.getRealPrice() * cartVO.getNum();
        }
        Address address = addressService.getByAid(aid, uid);
        Order order = new Order();
        order.setUid(uid);
        //收货地址数据
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        //支付、总价、时间
        order.setStatus(0);
        order.setTotalPrice(totalPrice);
        order.setOrderTime(new Date());
        // 日志
        order.setCreatedUser(username);
        order.setCreatedTime(new Date());
        order.setModifiedUser(username);
        order.setModifiedTime(new Date());
        //插入数据
        Integer rows = orderMapper.insertOrder(order);
        if (rows!=1) {
            throw new InsertException("插入数据异常");
        }
        //创建订单详细项的数据
        for (CartVO cartVO : list) {
            //创建一个订单项数据对象
            OrderItem orderItem = new OrderItem();
            orderItem.setOid(order.getOid());
            orderItem.setPid(cartVO.getPid());
            orderItem.setTitle(cartVO.getTitle());
            orderItem.setImage(cartVO.getImage());
            orderItem.setPrice(cartVO.getRealPrice());
            orderItem.setNum(cartVO.getNum());
            //日志字段
            orderItem.setCreatedUser(username);
            orderItem.setCreatedTime(new Date());
            orderItem.setModifiedUser(username);
            orderItem.setModifiedTime(new Date());
            // 插入数据操作
            rows = orderMapper.insertOrderItem(orderItem);
            if (rows!=1) {
                throw new InsertException("插入数据异常");
            }
        }
        return order;
    }
}
