package com.bawei.guolei.guanzong;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lenovo on 2017/12/17.
 */

public class MysAdapter extends RecyclerView.Adapter {

    Context context;
    List<String> list1;
    List<Integer> list2;
    public MysAdapter(Context context, List<String> list1, List<Integer> list2) {
    this.context=context;
    this.list1=list1;
    this.list2=list2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         ViewHolder viewHolder= (ViewHolder) holder;
         viewHolder.image.setImageResource(list2.get(position));
         viewHolder.title.setText(list1.get(position));

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;
        private final ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image=itemView.findViewById(R.id.image);
        }
    }
}
