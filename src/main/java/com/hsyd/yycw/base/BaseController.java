package com.hsyd.yycw.base;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 所有请求处理的父类
 * Created by duan on 2017/5/17.
 */
@Controller
public abstract class BaseController {

    @Value("${api.response.template}")
    private String template;
//
//    @Autowired
//    protected SmsService smsService;
//
//    protected Integer getSmsSessionTimeOut(){
//
//        return Integer.parseInt(timeOuntMsg != null ? timeOuntMsg : "1")*60;
//    }

//    /**
//     * 获得当前登录用户
//     */
//    protected User getUser(){
//
//        return (User)SecurityUtils.getSubject().getPrincipal();
//    }
//
//    /**
//     * 获得用户手机号
//     */
//    protected String getUserPhone(){
//
//        return getUser().getPhone();
//    }
//
//    /**
//     * 获得用户编号
//     */
//    protected String getUserId(){
//
//        return getUser().getUserId();
//    }

    /**
     * 获得当前毫秒数
     */
    protected long getCurrentTimeMillis() {

        return System.currentTimeMillis();
    }

    protected static final String MESSAGE_SUCCESS = "0";
    protected static final String MESSAGE_ERROR = "1";
    protected static final String MESSAGE_SUCCESS_CODE = "SUCCESS";

    /**
     * 统一响应信息设置(适用查询)
     *
     * @param errorMsg 错误信息
     * @param data     响应数据
     * @return 响应结果
     */
    protected String response(String errorMsg, List data) {
        String result = this.template;
        result = result.replace("{code}", MESSAGE_SUCCESS.equals(errorMsg) ? MESSAGE_SUCCESS : MESSAGE_ERROR);
        result = result.replace("{msg}", MESSAGE_SUCCESS.equals(errorMsg) ? MESSAGE_SUCCESS_CODE : errorMsg);
        result = result.replace("{data}", data == null ? "[]" : JSONArray.fromObject(data).toString());
        return result;
    }

}
