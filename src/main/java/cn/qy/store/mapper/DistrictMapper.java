package cn.qy.store.mapper;

import cn.qy.store.entity.District;

import java.util.List;

/**
 * @description: 获取省市区列表的接口
 * @author: QiuYang
 * @time: 2022/7/20
 */
public interface DistrictMapper {
    /*
    * 根据父代号查询区域信息
    * @param parent 父代号
    * @return 某个父区域下的所有区域列表
    *
    * */
    List<District> findByParent(String parent);

    String findNameByCode(String code);
}
