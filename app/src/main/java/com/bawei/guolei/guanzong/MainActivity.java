package com.bawei.guolei.guanzong;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.guolei.guanzong.Fragments.Fragment_01;
import com.bawei.guolei.guanzong.Fragments.Fragment_02;
import com.bawei.guolei.guanzong.Fragments.Fragment_03;
import com.bawei.guolei.guanzong.Fragments.Fragment_04;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RadioGroup radioGroup;
    private List<Fragment> list;
    private ViewPager viewPager;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.group);
        viewPager = findViewById(R.id.view_pager);

        list = new ArrayList<>();
        list.add(new Fragment_01());
        list.add(new Fragment_02());
        list.add(new Fragment_03());
        list.add(new Fragment_04());
        adapter = new MyAdapter(getSupportFragmentManager(),list);
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
                    case R.id.radio_01:
                        viewPager.setCurrentItem(0,false);
                        break;
                    case R.id.radio_02:
                        viewPager.setCurrentItem(1,false);
                        break;
                    case R.id.radio_03:
                        viewPager.setCurrentItem(2,false);
                        break;
                    case R.id.radio_04:
                        viewPager.setCurrentItem(3,false);
                        break;
                }
            }
        });
        viewPager.setOffscreenPageLimit(4);









    }
}
