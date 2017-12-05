package com.guaju.smsverifymvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by guaju on 2017/12/4.
 */

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
    }

    //强制让子类去设置presenter
  public  abstract  void  setPresenter();

}
