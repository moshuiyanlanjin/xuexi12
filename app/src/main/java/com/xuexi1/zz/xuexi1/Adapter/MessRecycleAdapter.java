package com.xuexi1.zz.xuexi1.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xuexi1.zz.xuexi1.Mode.Messg;
import com.xuexi1.zz.xuexi1.R;

import java.util.List;

/**
 * Created by Administrator on 2018-03-01.
 */

public class MessRecycleAdapter extends RecyclerView.Adapter<MessRecycleAdapter.ViewHoled>{
    private List<Messg> msglist;
    public MessRecycleAdapter(List<Messg> msglist) {
        this.msglist = msglist;
    }

    @Override
    public ViewHoled onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHoled holed = new ViewHoled(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_msg,parent,false));
        return holed;
    }

    @Override
    public void onBindViewHolder(ViewHoled holder, int position) {
        Messg msg = msglist.get(position);
        if(msg.type == Messg.TYPE_ROOM){
            holder.shou.setVisibility(View.GONE);
            holder.song.setVisibility(View.VISIBLE);
            Log.d("收到",msg.getSendmsg());
            holder.shoutext.setTextColor(Color.BLACK);
            holder.shoutext.setText(msg.getSendmsg());
        }else if(msg.type == Messg.TYPE_SEND){
            holder.shou.setVisibility(View.VISIBLE);
            holder.song.setVisibility(View.GONE);
            holder.songtext.setText("asdajksdhn");
            Log.d("送到",msg.getSendmsg());
        }
    }

    @Override
    public int getItemCount() {
        return msglist.size();
    }

    public class ViewHoled extends RecyclerView.ViewHolder {
        LinearLayout shou;
        LinearLayout song;
        TextView shoutext;
        TextView songtext;
        public ViewHoled(View itemView) {
            super(itemView);
            shou = itemView.findViewById(R.id.shou);
            song = itemView.findViewById(R.id.song);
            shoutext = (TextView) itemView.findViewById(R.id.shoutext);
            songtext = (TextView)itemView.findViewById(R.id.songtext);
        }
    }
}
