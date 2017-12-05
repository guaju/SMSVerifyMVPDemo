package com.guaju.smsverifymvpdemo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by guaju on 2017/12/4.
 */

public class VerifyNum {
    //校验手机号
    public static boolean verifyPhoneNum(String  str){
        //通过正则表达式校验
//      String pattern="^1[3,4,5,7,8,9]\\d{9}$";
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147)|19[0-9])\\d{8}$";
        //模型
        Pattern p = Pattern.compile(regExp);
        //对比器
        Matcher m = p.matcher(str);
        return m.matches();
    }

    //校验邮箱
    //正则表达式的用法：主要是用来匹配字符串的    www.baidu121232183123216372163123.com
    //www\.baidu\\d{6}\.\\w{3}  就能够识别 www.baidu
    //数字/字母@数字/字母.数字/字母        \d    \w   \s    \@    \.    \d*   +  ?
    //*表示  0个或者多个
    //+表示  1个或者多个
    //？0 或 1


}
