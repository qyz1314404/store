package cn.qy.store.service.impl;

import cn.qy.store.entity.Address;
import cn.qy.store.mapper.AddressMapper;
import cn.qy.store.service.IAddressService;
import cn.qy.store.service.IDistrictService;
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
    //在添加用户的收货地址的业务层依赖于IDistrictService的业务层接口
    @Autowired
    private IDistrictService districtService;
    @Value("${user.address.max-count}")
    private Integer maxCount;
    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        //调用收货地址统计的方法
        Integer count = addressMapper.countByUid(uid);
        if (count == maxCount) {
            throw new AddressCountLimitException("用户收货地址超出上限");
        }
        //对address对象中的省市区数据进行补全,因为从前端页面传过来的并没有名字只有代号。所以需要借用district应用层的方法使用代号来获取名字。
        String provinceName = districtService.getNameByCode(address.getProvinceCode());
        String cityName = districtService.getNameByCode(address.getCityCode());
        String areaName = districtService.getNameByCode(address.getAreaCode());
        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);


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
