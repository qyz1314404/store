package cn.qy.store.controller;

import cn.qy.store.service.ex.InsertException;
import cn.qy.store.service.ex.ServiceException;
import cn.qy.store.service.ex.UsernameDuplicatedException;
import cn.qy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @description: 控制层类的基类
 * @author: QiuYang
 * @time: 2022/7/2
 */
public class BaseController {
    /*操作成功的状态码*/
    public static final int OK = 200;

    //自动将异常对象传递给此方法的参数列表上
//当前项目中产生了异常，被统一拦截到此方法中，这个方法此时充当的是请求方法，方法的返回值直接给前端
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        }
        return result;
    }

}
