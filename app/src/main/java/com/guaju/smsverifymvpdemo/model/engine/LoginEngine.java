package com.guaju.smsverifymvpdemo.model.engine;

import com.guaju.smsverifymvpdemo.bean.BaseBean;
import com.guaju.smsverifymvpdemo.constant.Constant;
import com.guaju.smsverifymvpdemo.http.OkHttpUtil;
import com.guaju.smsverifymvpdemo.utils.SignUtil;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by guaju on 2017/12/1.
 */

public class LoginEngine {


    //发送验证码 已经停用了
    public BaseBean getVerifyCode(String phone) throws IOException {
        //请求需要的参数有：bs,phone,ip,mac,time,sign,type
        String bs= "sms";
        String ip="106.37.12.133";
        String mac="b4:0b:44:80:da:a0";
        int type=1;
        long time=System.currentTimeMillis()/1000;
        //现在要得到签名，需要time,"",phone,ip
        String sign= SignUtil.encryptSign((time-444)+"",phone,ip);
        HashMap<String, String> map = new HashMap<>();
        map.put("bs",bs);
        map.put("phone",phone);
        map.put("ip",ip);
        map.put("mac",mac);
        map.put("time",time+"");
        map.put("sign",sign);
        map.put("type",type+"");

       BaseBean bean=OkHttpUtil.getInstance().postBean(Constant.VERIFY_CODE,map);
//        {code:200,result}
       return bean;





    }
    //登录逻辑，手机号:phone和验证码:sms
        public BaseBean login(String  phone,String sms) throws IOException {
        //应该是一个校验的算法
        String cid="a52fd360a022f8fd84aafb72ead49588";
        String bs="login";
        HashMap<String, String> map = new HashMap<>();
        map.put("bs",bs);
        map.put("cid",cid);
        map.put("phone",phone);
        map.put("sms",sms);
        BaseBean bean = OkHttpUtil.getInstance().postBean(Constant.LOGIN, map);
        return bean;
    }

}
