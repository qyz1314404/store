package cn.qy.store.service.impl;

import cn.qy.store.entity.District;
import cn.qy.store.mapper.DistrictMapper;
import cn.qy.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/20
 */
@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);
        /*
        * 在进行网络数据传输时，为了尽量避免无效数据的传递，可以将无效数据设置为null，
        * 可以节省流量，另一方面提升效率
        * */
        for (District d : list) {
            d.setId(null);
            d.setParent(null);
        }
        return list;
    }
}
