package com.bawei.guolei.guanzong.model;

import okhttp3.Callback;

/**
 * Created by asus on 2017/11/7.
 */

public interface Ilogin {
    public void getNetData(String phone, String pwd, Callback callback);
}
