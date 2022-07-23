package cn.qy.store.controller;

import cn.qy.store.controller.ex.*;
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
    @ExceptionHandler({ServiceException.class,FileUploadException.class})
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
        } else if (e instanceof UpdateException) {
            result.setState(5003);
            result.setMessage("更新数据时产生未知的异常");
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
            result.setMessage("用户上传的文件为空的异常");
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
            result.setMessage("用户上传的文件大小超出了限制值的异常");
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
            result.setMessage("用户上传的文件类型超出了限制的异常");
        } else if (e instanceof FileStateException) {
            result.setState(6003);
            result.setMessage("用户上传的文件状态的异常");
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
            result.setMessage("用户上传文件时读写的异常");
        } else if (e instanceof AddressCountLimitException) {
            result.setState(6005);
            result.setMessage("用户的收货地址超出上限的异常");
        }else if (e instanceof AddressNotFoundException) {
            result.setState(6006);
            result.setMessage("用户的收货地址数据不存在的异常");
        }else if (e instanceof AccessDeniedException) {
            result.setState(6007);
            result.setMessage("收货地址数据非法访问的异常");
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
