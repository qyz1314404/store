package cn.qy.store.controller;

import cn.qy.store.service.ICartService;
import cn.qy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/30
 */
@RequestMapping("carts")
@RestController
public class CartController extends BaseController {
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session) {
        cartService.addToCart(getUidFromSession(session),pid,amount,getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
}
