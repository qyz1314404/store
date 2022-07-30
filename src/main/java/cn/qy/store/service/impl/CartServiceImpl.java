package cn.qy.store.service.impl;

import cn.qy.store.entity.Cart;
import cn.qy.store.entity.Product;
import cn.qy.store.mapper.CartMapper;
import cn.qy.store.mapper.ProductMapper;
import cn.qy.store.service.ICartService;
import cn.qy.store.service.ex.InsertException;
import cn.qy.store.service.ex.UpdateException;
import cn.qy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/30
 */
@Service
public class CartServiceImpl implements ICartService {
    /*购物车的业务层依赖于购物车的持久层以及商品的持久层*/
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
        Cart cart = new Cart();
        Date date = new Date();
        //查询当前要添加的这个购物车是否在表中已存在
        Cart result = cartMapper.findByUidAndPid(uid, pid);
        if (result == null) {//表示这个商品从来没有被添加到购物车中，则进行新增操作
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            //价格：来自于商品中的数据
            Product product = productMapper.findById(pid);
            cart.setPrice(product.getPrice());
            //补全4个日志
            cart.setCreatedUser(username);
            cart.setCreatedTime(date);
            cart.setModifiedUser(username);
            cart.setModifiedTime(date);
            //执行数据的插入操作
            Integer rows = cartMapper.insert(cart);
            if (rows!=1) {
                throw new InsertException("插入数据时产生未知的异常");
            }
        } else {//表示当前的商品在购物车中已经存在，则更新这条数据的num值
            //已经进行了与原有数据的相加（此操作可以在前端写好传过来，也可以后端来做处理）
            Integer num = result.getNum() + amount;
            Integer rows = cartMapper.updateNumByCid(result.getCid(), num, username, date);
            if (rows!=1) {
                throw new UpdateException("更新数据时产生未知的异常");
            }

        }
    }
    @Override
    public List<CartVO> getVOByUid(Integer uid) {
        return cartMapper.findVOByUid(uid);
    }
}
