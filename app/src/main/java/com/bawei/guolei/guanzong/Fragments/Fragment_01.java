package com.bawei.guolei.guanzong.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.guolei.guanzong.R;
import com.bawei.guolei.guanzong.TableLayoutAdapter;
import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Lenovo on 2017/12/15.
 */

public class Fragment_01 extends Fragment {


    private ViewPager viewPager;
    private List<String> titlelist;
    private TabLayout tabLayout;
    private List<Fragment> listfragment;
    private Fragment_001 fragment001;
    private Fragment_002 fragment002;
    private Fragment_003 fragment003;
    private Fragment_004 fragment004;
    private Fragment_005 fragment005;
    private Fragment_006 fragment006;
    private Fragment_007 fragment007;
    private Fragment_008 fragment008;
    private TableLayoutAdapter adapter;
    private TextView quanguo;
    private static final int REQUEST_CODE_PICK_CITY = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_01, container, false);
        tabLayout = view.findViewById(R.id.main_tab);
        viewPager = view.findViewById(R.id.main_viewpager);
        quanguo = view.findViewById(R.id.quanguo);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       titlelist = new ArrayList<>();
        titlelist.add("全部");
        titlelist.add("综艺娱乐");
        titlelist.add("财经访谈");
        titlelist.add("文化旅游");
        titlelist.add("时尚体育");
        titlelist.add("青少科教");
        titlelist.add("养生保养");
        titlelist.add("公益");

        viewPager.setOffscreenPageLimit(titlelist.size());


                fragment001 = new Fragment_001();
                fragment002 = new Fragment_002();
                fragment003 = new Fragment_003();
                fragment004 = new Fragment_004();
                fragment005 = new Fragment_005();
                fragment006 = new Fragment_006();
                fragment007 = new Fragment_007();
                fragment008 = new Fragment_008();

                listfragment = new ArrayList<>();
                listfragment.add(fragment001);
                listfragment.add(fragment002);
                listfragment.add(fragment003);
                listfragment.add(fragment004);
                listfragment.add(fragment005);
                listfragment.add(fragment006);
                listfragment.add(fragment007);
                listfragment.add(fragment008);

        adapter = new TableLayoutAdapter(getChildFragmentManager(),listfragment,titlelist);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        quanguo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//启动
                startActivityForResult(new Intent(getActivity(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);


            }
        });





    }
    //重写onActivityResult方法
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
            if (data != null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                quanguo.setText("当前选择：" + city);
            }
        }
    }








    }

