package com.bawei.guolei.guanzong.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.guolei.guanzong.R;
import com.bawei.guolei.guanzong.TabAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/12/17.
 */

public class Fragment_baoming extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> tilist;
    private Fragment_a fragment_a;
    private Fragment_b fragment_b;
    private Fragment_c fragment_c;
    private Fragment_d fragment_d;
    private List<Fragment> list;
    private TabAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_baoming,container,false);

        tabLayout = view.findViewById(R.id.main_tab);
        viewPager = view.findViewById(R.id.view_pagers);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tilist = new ArrayList<>();
        tilist.add("待审核");
        tilist.add("待支付");
        tilist.add("待参加");
        tilist.add("已完成");

        viewPager.setOffscreenPageLimit(tilist.size());
        fragment_a = new Fragment_a();
        fragment_b = new Fragment_b();
        fragment_c = new Fragment_c();
        fragment_d = new Fragment_d();

        list = new ArrayList<>();
        list.add(fragment_a);
        list.add(fragment_b);
        list.add(fragment_c);
        list.add(fragment_d);

        adapter = new TabAdapter(getChildFragmentManager(),tilist,list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}
