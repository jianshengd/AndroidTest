package com.example.jianshengd.v_layout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

import java.util.List;

/**
 * Created by Administrator on 2018/8/7
 */
class DelegateRecyclerAdapter extends DelegateAdapter.Adapter<DelegateRecyclerAdapter.MyViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private List<String> items;
    public DelegateRecyclerAdapter(Context context, LayoutHelper layoutHelper,List<String> items) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.items=items;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_content.setText(items.get(position));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_content;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_content=itemView.findViewById(R.id.tv_content);
        }
    }
}
