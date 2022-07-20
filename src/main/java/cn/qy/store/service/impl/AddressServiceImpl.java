package cn.qy.store.service.impl;

import cn.qy.store.entity.Address;
import cn.qy.store.mapper.AddressMapper;
import cn.qy.store.service.IAddressService;
import cn.qy.store.service.ex.AddressCountLimitException;
import cn.qy.store.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description: 新增收货地址的实现类
 * @author: QiuYang
 * @time: 2022/7/20
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Value("${user.address.max-count}")
    private Integer maxCount;
    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        //调用收货地址统计的方法
        Integer count = addressMapper.countByUid(uid);
        if (count == maxCount) {
            throw new AddressCountLimitException("用户收货地址超出上限");
        }
        address.setUid(uid);
        Integer isDefault = count == 0 ? 1 : 0;
        address.setIsDefault(isDefault);
        // 补全4项日志
        address.setCreatedUser(username);
        address.setModifiedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedTime(new Date());
        // 插入收货地址的方法
        Integer rows = addressMapper.insert(address);
        if (rows != 1) {
            throw new InsertException("插入用户的收货地址产生未知异常");
        }
    }
}