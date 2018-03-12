package com.xuexi1.zz.xuexi1.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xuexi1.zz.xuexi1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-03-01.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolde> {
    private List<String> firlist = new ArrayList<>();
    public MyRecycleAdapter(List<String> firlist) {
        this.firlist = firlist;
    }

    private BtOnClite btOnClite;
    @Override
    public ViewHolde onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_myrecy,parent,false);
        ViewHolde holder = new ViewHolde(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolde holder, final int position) {
        holder.text3.setText(firlist.get(position));
        holder.btview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btOnClite.onclike(position);
            }
        });
    }

    public interface BtOnClite{
         void onclike(int position);
    }
    @Override
    public int getItemCount() {

        return firlist.size();
    }

    public class ViewHolde extends RecyclerView.ViewHolder {
        TextView text3;
        View btview;
        public ViewHolde(View itemView) {
            super(itemView);
            text3 = itemView.findViewById(R.id.text3);
            btview = itemView;
        }
    }
    public void MyRecycleOnclike(BtOnClite btOnClite){
        this.btOnClite = btOnClite;
    }
}
