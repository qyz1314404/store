package cn.qy.store.controller;

import cn.qy.store.entity.Address;
import cn.qy.store.service.IAddressService;
import cn.qy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/20
 */
@RequestMapping("addresses")
@RestController
public class AddressController extends BaseController {
    @Autowired
    IAddressService addressService;
@RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session) {
    Integer uid = getUidFromSession(session);
    String username = getUsernameFromSession(session);
    addressService.addNewAddress(uid,username,address);
    return new JsonResult<>(OK);
}

    @RequestMapping({"", "/"})
    public JsonResult<List<Address>> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<Address> data = addressService.getByUid(uid);
        return new JsonResult<>(OK, data);
    }

    //RestFul风格的请求编写
    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session) {
    addressService.setDefault(aid,getUidFromSession(session),getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }

    @RequestMapping("{aid}/delete")
    public JsonResult<Void> delete(@PathVariable("aid") Integer aid, HttpSession session) {
    addressService.delete(aid,getUidFromSession(session),getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }

}
