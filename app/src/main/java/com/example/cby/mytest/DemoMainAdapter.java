package com.example.cby.mytest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by chenbiyue on 2019/10/30.
 */

public class DemoMainAdapter extends RecyclerView.Adapter {
    private Context context;

    private ItemOnClickListener listener;
    private List<String> datas;

    public DemoMainAdapter(Context context,List<String> datas) {
        this.context = context;
        this.datas = datas;
        listener = (ItemOnClickListener) context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.demo_main_item_layout,null,false);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MainViewHolder mainViewHolder = (MainViewHolder) holder;
        mainViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setTag(mainViewHolder);
                listener.onItemClick(view,position);
            }
        });
        mainViewHolder.textView.setText(datas.get(position));

    }

    @Override
    public int getItemCount() {
        if (datas!=null && datas.size()>0){
            return datas.size();
        }
        return 0;

    }

    private class MainViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public MainViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.demo_main_item_tv);

        }
    }

}
