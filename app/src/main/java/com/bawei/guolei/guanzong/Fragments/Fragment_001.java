package com.bawei.guolei.guanzong.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.guolei.guanzong.R;
import com.bawei.guolei.guanzong.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/12/16.
 */

public class Fragment_001 extends Fragment {

    private ViewPager viewPager;
    private List<Integer> list;
    private ViewPagerAdapter viewPagerAdapter;
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==0){
                int currentItem=viewPager.getCurrentItem();
                viewPager.setCurrentItem(currentItem+1);

                handler.sendEmptyMessageDelayed(0,1000);
            }
        };
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_001,container,false);

        viewPager = view.findViewById(R.id.viewpager);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        list = new ArrayList<>();
        list.add(R.mipmap.a);
        list.add(R.mipmap.b);
        list.add(R.mipmap.c);
        list.add(R.mipmap.d);

        viewPagerAdapter = new ViewPagerAdapter(list,getActivity());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(list.size()*100000);
        handler.sendEmptyMessageDelayed(0,1000);

    }
}
