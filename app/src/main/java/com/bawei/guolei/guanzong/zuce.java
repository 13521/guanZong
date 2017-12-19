package com.bawei.guolei.guanzong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bawei.guolei.guanzong.bean.ZcBean;
import com.bawei.guolei.guanzong.presenter.MyZcPresenter;
import com.bawei.guolei.guanzong.view.ShowZCview;


public class zuce extends AppCompatActivity  implements ShowZCview, View.OnClickListener {

    private ImageButton imageButton;
    private EditText mPhoneZc;
    private EditText mPwdZc;
    private Button mZhuceBt;
    MyZcPresenter presenter=new MyZcPresenter(this,this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuce);
        imageButton = findViewById(R.id.zuceimage);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initView();
    }

    private void initView() {
        mPhoneZc = (EditText) findViewById(R.id.zc_phone);
        mPwdZc = (EditText) findViewById(R.id.zc_pwd);
        mZhuceBt = (Button) findViewById(R.id.bt_zhuce);
        mZhuceBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_zhuce:
                presenter.clickzc(mPhoneZc.getText().toString(),mPwdZc.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void ShowZcView(ZcBean bean) {
        Toast.makeText(zuce.this, bean.getMsg(), Toast.LENGTH_SHORT).show();
    }
}
