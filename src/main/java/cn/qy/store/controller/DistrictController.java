package cn.qy.store.controller;

import cn.qy.store.entity.District;
import cn.qy.store.service.IDistrictService;
import cn.qy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/20
 */
@RequestMapping("districts")
@RestController
public class DistrictController extends BaseController{
    @Autowired
    private IDistrictService districtService;
    // districts开头的请求都被拦截到getByParent()方法
    @RequestMapping({"/",""})
    public JsonResult<List<District>> getByParent(String parent) {
        List<District> data = districtService.getByParent(parent);
        return new JsonResult<>(OK, data);
    }
}
