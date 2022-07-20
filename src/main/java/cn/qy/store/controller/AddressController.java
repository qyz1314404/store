package cn.qy.store.controller;

import cn.qy.store.entity.Address;
import cn.qy.store.service.IAddressService;
import cn.qy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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

}
