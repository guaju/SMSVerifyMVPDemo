package com.guaju.smsverifymvpdemo;

import com.guaju.smsverifymvpdemo.http.OkHttpUtil;
import com.guaju.smsverifymvpdemo.model.engine.LoginEngine;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by guaju on 2017/11/30.
 */

public class TestMethod {
    @Test
    public void getNewUrl() throws IOException {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","hehehe");
        map.put("pass","123456");
        //判断第二个参数的运算是不是第一个值
//        String s = OkHttpUtil.getInstance().get("https://www.baidu.com/", null);
        String s = OkHttpUtil.getInstance().map2Json(map);
        assertEquals("http://hehehe.com", s);
    }
    @Test
    public void verifyCode() throws IOException {
        LoginEngine loginEngine = new LoginEngine();
        String verifyCode = loginEngine.getVerifyCode("13511061487");
        assertEquals("xiao",verifyCode);
    }
    @Test
    public void login() throws IOException {
        LoginEngine loginEngine = new LoginEngine();
        String json = loginEngine.login("13511061487", "3893");
        assertEquals("hehe",json);
    }
}
