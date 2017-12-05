package com.guaju.smsverifymvpdemo.constant;

/**
 * Created by guaju on 2017/11/30.
 * 接口地址类
 */

public interface Constant {


    //主机地址
    String HOST="http://www.quanminlebang.com/";
    String API="api103/";
    //获取验证码
    String  VERIFY_CODE=HOST+API+"user.php";
    //登录
    String LOGIN=VERIFY_CODE;

}
