package com.bawei.guolei.guanzong;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Lenovo on 2017/12/17.
 */

public class TabAdapter extends FragmentPagerAdapter {
    List<String> tilist;
    List<Fragment> list;
    public TabAdapter(FragmentManager fm, List<String> tilist, List<Fragment> list) {
        super(fm);
        this.tilist=tilist;
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tilist.get(position%tilist.size());
    }
}
