package com.bawei.guolei.guanzong.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.bawei.guolei.guanzong.FragAdapter;
import com.bawei.guolei.guanzong.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/12/15.
 */

public class Fragment_03 extends Fragment {

    private RadioGroup radioGroup;
    private ViewPager viewPager;
    private List<Fragment> list;
    private FragAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_03,container,false);

        radioGroup = view.findViewById(R.id.radio_group);
        viewPager = view.findViewById(R.id.manage_viewpager);
        list = new ArrayList<>();
        list.add(new Fragment_baoming());
        list.add(new Fragment_bubao());
        adapter = new FragAdapter(getChildFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId){
                        case R.id.btn_01:
                            viewPager.setCurrentItem(0,false);
                            break;
                        case R.id.btn_02:
                            viewPager.setCurrentItem(1,false);
                            break;
                    }
           }
       });
       viewPager.setOffscreenPageLimit(2);


        return view;
    }
}
