package com.hsyd.yycw.controller;

import com.hsyd.yycw.base.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by xisowang on 14/08/2017.
 */
@Controller
public class LoginController extends BaseController {

    @RequestMapping("/login")
    public String login(String username, String password) {
        String message = MESSAGE_SUCCESS;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            message = "用户名不存在！";
        } catch (IncorrectCredentialsException e) {
            message = "用户名或密码错误";
        } catch (DisabledAccountException e) {
            message = "用户已经被禁用，请联系管理员解除";
        } catch (AccountException e) {
            message = "请输入用户名或密码";
        } catch (AuthenticationException e) {
            message = "登录失败，未知异常";
        }
        return response(message,null);
    }
    @RequestMapping("/index")
    public String index (){
        return "index";
    }


}
