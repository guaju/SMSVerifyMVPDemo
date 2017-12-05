package com.guaju.smsverifymvpdemo.utils;


import android.os.Build;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 与后台 ios  web前端 一起约定好的接口校验规则，一般来说，都会对参数进行一定规则的拼接，然后进行md5加密，
 * 得到的一个字符串 当做我们的接口签名 sign=""
 */

public class SignUtil {
    static String SALT = "3c66790a694fd53aed110a8e85f1aeec";
    public static String encryptSign(String t, String p, String i) {
        return MD5(t + p + SALT + i);
    }

    public static String MD5(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }



    public static boolean isFlyme() {
        if ("Flyme".equals(Build.MANUFACTURER)) {
            return true;
        } else {
            return false;
        }
     }
     }