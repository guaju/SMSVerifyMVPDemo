package com.guaju.smsverifymvpdemo.ui.login;

/**
 * Created by guaju on 2017/12/4.
 */

public interface LoginContract {
    //专门来处理view的变化
    interface  LoginView{
      //设置loginButton是否可用
      void  setLoginButtonEnable(boolean value);
      //提示校验失败
      void  showVerifyError();
      //提示检验成功过,等于说登录成功
      void  showVerifySuccess();
      //展示手机号为空的
      void  showPhoneNumEmpty();
      //手机号格式不对
      void  showPhoneNumError();
      //监听验证码框的变化
      void  listenSmsEditTextStatus();

    }
    //处理业务逻辑
    interface Presenter{
        //请求发送校验码
        void requestVerifyCode();
        //检验验证码是否可用，跟登录一致
        void  verifySmsCode();


    }


}
