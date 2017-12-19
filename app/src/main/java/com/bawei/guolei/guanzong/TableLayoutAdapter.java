package com.bawei.guolei.guanzong;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Lenovo on 2017/12/16.
 */

public class TableLayoutAdapter extends FragmentPagerAdapter {

    private List<Fragment> listfragment;

    private List<String> titlelist;


    public TableLayoutAdapter(FragmentManager fm,List<Fragment> listfragment, List<String> titlelist) {
        super(fm);

        this.listfragment=listfragment;
        this.titlelist=titlelist;
    }

    @Override
    public Fragment getItem(int position) {
        return listfragment.get(position);
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position%titlelist.size());
    }
}
