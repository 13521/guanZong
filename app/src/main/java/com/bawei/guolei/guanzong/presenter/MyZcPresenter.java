package com.bawei.guolei.guanzong.presenter;

import android.content.Context;

import com.bawei.guolei.guanzong.bean.ZcBean;
import com.bawei.guolei.guanzong.model.MyZcModel;
import com.bawei.guolei.guanzong.okhttp.OnUiCallback;
import com.bawei.guolei.guanzong.view.ShowZCview;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by asus on 2017/11/7.
 */

public class MyZcPresenter {
    Context context;
    MyZcModel model;
    ShowZCview view;

    public MyZcPresenter(Context context, ShowZCview view) {
        this.context = context;
        this.view = view;
        model=new MyZcModel();
    }
    public void clickzc(String phone,String pwd ){
        model.getnetZCdata(phone, pwd, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                ZcBean bean = gson.fromJson(result, ZcBean.class);
                view.ShowZcView(bean);
            }
        });
    }

}
