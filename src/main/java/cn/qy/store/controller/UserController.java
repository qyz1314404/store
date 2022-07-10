package cn.qy.store.controller;

import cn.qy.store.entity.User;
import cn.qy.store.service.IUserService;
import cn.qy.store.service.ex.InsertException;
import cn.qy.store.service.ex.UsernameDuplicatedException;
import cn.qy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/6/30
 */
//@Controller
@RestController //@Controller+@ResponseBody
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;
/*
    @RequestMapping("reg")
    //@ResponseBody //表示此方法的响应结果以json格式进行数据的响应给前端
    public JsonResult<Void> reg(User user) {
        JsonResult<Void> result = new JsonResult<>();
        try {
            userService.reg(user);
            result.setState(200);
            result.setMessage("用户注册成功");
        } catch (UsernameDuplicatedException e) {
            result.setState(4000);
            result.setMessage("用户名被占用");
        }
        catch (InsertException e) {
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        }
        return result;
    }
*/
@RequestMapping("reg")
//@ResponseBody //表示此方法的响应结果以json格式进行数据的响应给前端
/*
* 1.接收数据方式：请求处理方法的参数列表设置为pojo类型来接收前端的数据，
* springboot会将前端的url地址中的参数名和pojo类的属性名进行比较，如果
* 这两个名称相同，则将值注入到pojo类中对应的属性上。
* */
public JsonResult<Void> reg(User user) {
       userService.reg(user);
    return new JsonResult<>(OK);
}

/*
* 2.接收数据方式：请求处理方法的参数列表设置为非pojo类型
* springboot会直接将请求的参数名和方法的参数名直接进行比较，
* 如果名称相同则自动完成值的依赖注入
*
* */
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password) {
        User data = userService.login(username, password);
        return new JsonResult<User>(OK,data);
    }
}
