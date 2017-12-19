package com.bawei.guolei.guanzong;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.guolei.guanzong.bean.LoginBean;
import com.bawei.guolei.guanzong.presenter.MyLogingPresenter;
import com.bawei.guolei.guanzong.view.ShowLoginView;


public class denglu extends AppCompatActivity implements View.OnClickListener,ShowLoginView {

    private EditText mPhoneEt;
    private EditText mPwdEt;
    private Button mLogBt;
    private TextView mZcBt;
    private ImageButton imageButton;
    MyLogingPresenter presenter=new MyLogingPresenter(this,this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        imageButton = findViewById(R.id.dengimage);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initView();

    }

    private void initView() {
        mPhoneEt = (EditText) findViewById(R.id.et_phone);
        mPwdEt = (EditText) findViewById(R.id.et_pwd);
        mLogBt = (Button) findViewById(R.id.bt_log);
        mLogBt.setOnClickListener(this);
        mZcBt = (TextView) findViewById(R.id.bt_zc);
        mZcBt.setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_log:
                if (!TextUtils.isEmpty(mPhoneEt.getText().toString())&&!TextUtils.isEmpty(mPwdEt.getText().toString())){

                    presenter.login(mPhoneEt.getText().toString(),mPwdEt.getText().toString());
                }else {
                    Toast.makeText(this,"用户名密码不正确",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.bt_zc:
                Intent intent=new Intent(denglu.this,zuce.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    public void showLogin(LoginBean bean) {
        Toast.makeText(denglu.this,bean.getMsg(),Toast.LENGTH_SHORT).show();

        if (bean.getMsg().equals("登录成功")){
            SharedPreferences sharedPreferences=this.getSharedPreferences("config",MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("islogin",true).commit();
            edit.putString("sjh",bean.getData().getMobile()).commit();
            finish();
            Intent intent=new Intent(denglu.this,MainActivity.class);
            startActivity(intent);



        }
    }


}
