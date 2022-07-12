package cn.qy.store.controller;

import cn.qy.store.service.ex.*;
import cn.qy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

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
        } else if (e instanceof UserNotFoundException) {
            result.setState(5001);
            result.setMessage("用户数据不存在的异常");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5002);
            result.setMessage("用户名的密码错误的异常");
        }
        return result;
    }

    /*
     * 获取session对象中的uid
     * @param session session对象
     * @return 当前登录的用户uid的值
     * */
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /*
     * 获取当前登录用户的username
     * @param session session对象
     * @return 当前登录用户的用户名
     * */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }
}
