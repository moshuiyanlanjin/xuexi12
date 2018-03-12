package com.xuexi1.zz.xuexi1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.xuexi1.zz.xuexi1.Fragment.OneFragment;
import com.xuexi1.zz.xuexi1.Fragment.RightFragment;
import com.xuexi1.zz.xuexi1.Fragment.TwoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-03-02.
 */

public class StateFragmentActivity extends BaesActicity {

    @BindView(R.id.rightfrag)
    FrameLayout rightfrag;
    private IntentFilter intentFilter;
    private MyNetBrReceive myNetBrReceive;
    private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statefragmnet);
        ButterKnife.bind(this);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Button lift = (Button) findViewById(R.id.lift);
        Button lift1 = (Button) findViewById(R.id.lift1);
        Button lift2 = (Button) findViewById(R.id.lift2);
        relspfragment(new RightFragment());
        lift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relspfragment(new OneFragment());
            }
        });
        lift1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relspfragment(new TwoFragment());
            }
        });
        lift2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StateFragmentActivity.this,WangluoActivity.class));
            }
        });
        initView();
    }
    private void initView() {
       // RightFragment fragmentById = (RightFragment) getFragmentManager().findFragmentById(R.id.rightfrag);
        intentFilter = new IntentFilter();
        intentFilter.addAction("gaibian");
        myNetBrReceive = new MyNetBrReceive();
        localBroadcastManager.registerReceiver(myNetBrReceive,intentFilter);

    }
    class MyNetBrReceive extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bu = intent.getExtras();
            String yun = bu.getString("nnn");
            Log.d("kan",yun);
            Toast.makeText(StateFragmentActivity.this,yun,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        localBroadcastManager.unregisterReceiver(myNetBrReceive);
    }

    private void relspfragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rightfrag,fragment);
        //能返回上一个碎片
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
