package com.guaju.smsverifymvpdemo.model.engine;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by guaju on 2017/12/5.
 */

public class SmsTextWatcher implements TextWatcher {

    public SmsTextWatcher(OnSmsComplete onSmsComplete) {
        this.onSmsComplete = onSmsComplete;
    }

    OnSmsComplete onSmsComplete;

    public interface  OnSmsComplete{
       void onComplete();
       void onEdit();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }
    //当文字发生变化的时候触发这个监听
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        int length = s.toString().length();
        if (length==4){
            //通过回调的方式人为控制变化
            onSmsComplete.onComplete();
        }else{
            onSmsComplete.onEdit();
        }
    }
}
