package cn.qy.store.service.impl;

import cn.qy.store.entity.Product;
import cn.qy.store.mapper.ProductMapper;
import cn.qy.store.service.IProductService;
import cn.qy.store.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/28
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findHotList() {
        List<Product> list = productMapper.findHotList();
        for (Product product : list) {
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedUser(null);
            product.setModifiedTime(null);
        }
        return list;
    }

    @Override
    public Product findById(Integer id) {
//根据参数id调用私有方法执行查询，获取商品数据
        Product product = productMapper.findById(id);
        //判断查询结果是否为null
        if (product == null) {
            //是，抛出ProductNotFoundException
            throw new ProductNotFoundException("尝试访问的商品不存在");
        }
        //将查询结果中的部分属性设置为null
        product.setPriority(null);
        product.setCreatedUser(null);
        product.setCreatedTime(null);
        product.setModifiedUser(null);
        product.setModifiedTime(null);
        //返回查询结果
        return product;
    }
}
