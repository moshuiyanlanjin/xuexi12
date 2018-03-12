package com.xuexi1.zz.xuexi1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.xuexi1.zz.xuexi1.Adapter.MessRecycleAdapter;
import com.xuexi1.zz.xuexi1.Mode.Messg;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-02-28.
 */

public class SecondActivity extends BaesActicity {
    @BindView(R.id.but)
    Button but;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.send)
    Button send;
    MessRecycleAdapter adapter;
    private List<Messg> msglist = new ArrayList<>();
    Boolean issend = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        Messg msg = new Messg("您好！", Messg.TYPE_ROOM);
        msglist.add(msg);
        Messg msg2 = new Messg("您好！", Messg.TYPE_SEND);
        msglist.add(msg2);
        Messg msg3 = new Messg("......", Messg.TYPE_ROOM);
        msglist.add(msg3);
    }

    private void initView() {
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent();
                intent.putExtra("se","ge");
                setResult(1,intent);
                finish();*/
                Intent intent = new Intent(SecondActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });
        LinearLayoutManager layputmanager = new LinearLayoutManager(SecondActivity.this);
        layputmanager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(layputmanager);
        adapter = new MessRecycleAdapter(msglist);
        recycle.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = edit.getText().toString().trim();
                if(!TextUtils.isEmpty(trim)){
                    if(issend){
                        Messg msg = new Messg(trim,Messg.TYPE_ROOM);
                        msglist.add(msg);
                        issend = false;
                    }else {
                        Messg msg = new Messg(trim,Messg.TYPE_SEND);
                        msglist.add(msg);
                        issend = true;
                    }

                    //刷新适配器
                    adapter.notifyItemInserted(msglist.size()-1);
                    //将数据添加至最后一行
                    recycle.scrollToPosition(msglist.size()-1);
                    edit.setText("");
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Log.d("ssss", "ssss");
        Intent intent = new Intent();
        intent.putExtra("se", "33");
        setResult(1, intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
