package com.bawei.guolei.guanzong.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.guolei.guanzong.MysAdapter;
import com.bawei.guolei.guanzong.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/12/16.
 */

public class Fragment_008 extends Fragment {
    private RecyclerView recyclerView;
    private List<String> list1;
    private List<Integer> list2;
    private MysAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_008,container,false);
        recyclerView = view.findViewById(R.id.recycle_view);
        list1 = new ArrayList<>();
        list1.add("2017北京：国际脱口秀");
        list1.add("话剧《罗密欧与朱丽叶");
        list1.add("话剧《我的梦》");
        list1.add("2022冬季奥运会筹备中");
        list1.add("柒个我7重人格");
        list1.add("吐槽大会2");
        list1.add("2018贺岁片");
        list1.add("你的世界你做主");
        list1.add("我的世界你的梦");
        list2 = new ArrayList<>();
        list2.add(R.mipmap.aa);
        list2.add(R.mipmap.bb);
        list2.add(R.mipmap.cc);
        list2.add(R.mipmap.dd);
        list2.add(R.mipmap.ee);
        list2.add(R.mipmap.ff);
        list2.add(R.mipmap.gg);
        list2.add(R.mipmap.ll);
        list2.add(R.mipmap.h);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);

        adapter = new MysAdapter(getActivity(),list1,list2);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
