package cn.qy.store.mapper;

import cn.qy.store.entity.Product;

import java.util.List;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/28
 */
public interface ProductMapper {
    List<Product> findHotList();
    Product findById(Integer id);
}
