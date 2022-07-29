package cn.qy.store.service;

import cn.qy.store.entity.Product;

import java.util.List;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/28
 */
public interface IProductService {
    List<Product> findHotList();

    Product findById(Integer id);
}
