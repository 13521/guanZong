package com.bawei.guolei.guanzong;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Lenovo on 2017/12/16.
 */

public class ViewPagerAdapter extends PagerAdapter {
    List<Integer> list;
    Context context;
    public ViewPagerAdapter(List<Integer> list, Context context) {
        this.list=list;
        this.context=context;

    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(list.get(position%list.size()));
        container.addView(imageView);


        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
