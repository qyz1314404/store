package cn.qy.store.service;

import cn.qy.store.entity.Address;

import java.util.List;

/**
 * @description: 收货地址业务层接口
 * @author: QiuYang
 * @time: 2022/7/20
 */
public interface IAddressService {
    void addNewAddress(Integer uid, String username, Address address);

    List<Address> getByUid(Integer uid);
}
