package cn.qy.store.controller;

import cn.qy.store.service.ICartService;
import cn.qy.store.util.JsonResult;
import cn.qy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping({"", "/"})
    public JsonResult<List<CartVO>> getVOByUid(HttpSession session) {
        List<CartVO> data = cartService.getVOByUid(getUidFromSession(session));
        return new JsonResult<>(OK, data);
    }
    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid")Integer cid, HttpSession session) {
        Integer data = cartService.addNum(cid, getUidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK, data);
    }
    @RequestMapping("list")
    public JsonResult<List<CartVO>> getVOByCid(Integer[] cids,HttpSession session) {
        List<CartVO> data = cartService.getVOByCid(getUidFromSession(session),cids);
        return new JsonResult<>(OK, data);
    }
}
