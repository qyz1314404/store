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

    /*
    * 修改用户的某条收货地址数据为默认收货地址
    * @param aid 收货地址的id
    * @param uid 用户的id
    * @param username 表示修改执行的人
    * */
    void setDefault(Integer aid, Integer uid, String username);
}
