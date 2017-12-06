package com.guaju.smsverifymvpdemo.ui.login;

import android.text.TextUtils;
import android.view.View;

import com.guaju.smsverifymvpdemo.R;
import com.guaju.smsverifymvpdemo.base.BasePresenterImpl;
import com.guaju.smsverifymvpdemo.bean.BaseBean;
import com.guaju.smsverifymvpdemo.model.engine.LoginEngine;
import com.guaju.smsverifymvpdemo.utils.VerifyNum;

import java.io.IOException;

/**
 * Created by guaju on 2017/12/4.
 */

public class LoginPresenter extends BasePresenterImpl implements LoginContract.Presenter,View.OnClickListener {
    LoginEngine loginEngine=new LoginEngine();
    //声明view实现类
    LoginContract.LoginView loginView;
    LoginActivity loginActivity;

    public LoginPresenter(LoginContract.LoginView loginView) {
        super(loginView);
        this.loginView = loginView;
        loginActivity=(LoginActivity)loginView;

    }

    //可以持有view的实现类，从实现类中去拿对应的控件
    //或者单独提供方法，传入对应的参数：即手机号

    @Override
    public void requestVerifyCode() {
        //当验证码发送成功之后去监听按钮的状态
        loginActivity.listenSmsEditTextStatus();
        //发送验证码的点击事件
        loginActivity.sendsms.setOnClickListener(this);

    }

    @Override
    public void verifySmsCode() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sendsms:
                //检验手机号
                final String phone = loginActivity.phone.getText().toString().trim();
                if (TextUtils.isEmpty(phone)){
                    //展示手机号为空状态
                    loginActivity.showPhoneNumEmpty();
                    return;
                }else if(!VerifyNum.verifyPhoneNum(phone)){
                    loginActivity.showPhoneNumError();
                    return;
                }



                //请求验证码
                try {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            BaseBean baseBean = null;
                            try {
                                baseBean = loginEngine.getVerifyCode(phone);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (baseBean==null){
                                loginActivity.showVerifyError();
                                return;
                            }
                            int code = baseBean.getCode();
                            if (200==code){
                                //说明校验码发送成功
                                loginActivity.showVerifySuccess();

                            }
                            else{
                                //说明校验码发送失败
                                loginActivity.showVerifyError();
                            }

                        }
                    }).start();



                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
//            case :
//                break;
            default:
                break;

        }
    }
}
