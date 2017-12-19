package com.bawei.guolei.guanzong;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TuidengluActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuidenglu);

        btn = findViewById(R.id.button);
        SharedPreferences sharedPreferences=this.getSharedPreferences("config", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TuidengluActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
