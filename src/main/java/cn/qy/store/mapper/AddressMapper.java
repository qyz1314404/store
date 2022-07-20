package cn.qy.store.mapper;

import cn.qy.store.entity.Address;

/**
 * @description: 收获地址持久层的接口
 * @author: QiuYang
 * @time: 2022/7/19
 */
public interface AddressMapper {
    /*
     *插入用户的收货地址数据
     *@param address 收获地址数据
     *@return 受影响的行数
     * */
    Integer insert(Address address);

    /*
     *根据用户的id统计收货地址数量
     *@param uid 用户的id
     *@return 当前用户的收货地址总数
     *
     * */
    Integer countByUid(Integer uid);
}
