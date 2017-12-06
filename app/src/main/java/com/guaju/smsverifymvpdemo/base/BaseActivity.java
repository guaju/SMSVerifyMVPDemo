package com.guaju.smsverifymvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.guaju.smsverifymvpdemo.R;
import com.guaju.smsverifymvpdemo.utils.ToastUtil;

/**
 * Created by guaju on 2017/12/4.
 */

public abstract class BaseActivity extends Activity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
    }

    //强制让子类去设置presenter
  public  abstract  void  setPresenter();

    @Override
    public void noNetWork() {
        ToastUtil.show(this, R.string.nonetwork);
    }
}
