package com.bawei.guolei.guanzong.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bawei.guolei.guanzong.R;
import com.bawei.guolei.guanzong.TuidengluActivity;
import com.bawei.guolei.guanzong.denglu;

/**
 * Created by Lenovo on 2017/12/15.
 */

public class Fragment_04 extends Fragment {


    private TextView text;
    private ImageButton btn;
    private ImageButton deng;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_04,container,false);

        text = view.findViewById(R.id.text_view);
        btn = view.findViewById(R.id.tiaozhuan);
        deng = view.findViewById(R.id.wo);

        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        boolean islogin = sharedPreferences.getBoolean("islogin", false);
        if (islogin){
            String sjh = sharedPreferences.getString("sjh", null);
            text.setText(sjh);
            

        }else{

            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(getActivity(),denglu.class);
                    getActivity().startActivity(intent1);
                    getActivity().finish();
                }
            });
            

        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TuidengluActivity.class);
                getActivity().startActivity(intent);

            }
        });








        return view;
    }
}
