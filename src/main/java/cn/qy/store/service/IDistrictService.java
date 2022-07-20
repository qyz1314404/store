package cn.qy.store.service;

import cn.qy.store.entity.District;

import java.util.List;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/20
 */
public interface IDistrictService {
    /*
     * 根据父代号来查询区域信息（省市区）
     * @param parent 父代码
     * @return 多个区域的信息
     * */
    List<District> getByParent(String parent);
}
