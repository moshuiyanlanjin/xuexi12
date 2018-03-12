package com.xuexi1.zz.xuexi1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xuexi1.zz.xuexi1.View.TitleLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-03-05.
 */

public class WangluoActivity extends BaesActicity {
    @BindView(R.id.send)
    Button send;
    @BindView(R.id.title)
    TitleLayout title;
    private IntentFilter intentfilter;
    private NetworkChangeReceive networkchangereceive;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actviity_wangluo);
        ButterKnife.bind(this);
        //意图过滤器
        intentfilter = new IntentFilter();
        //获得网络变动广播意图
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        //广播接受
        networkchangereceive = new NetworkChangeReceive();
        //注册
        registerReceiver(networkchangereceive, intentfilter);
        initView();
    }


    public void initView() {

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.xuexi1.zz.xuexi1.broadcasttest.MY_RECEIVE");
                sendOrderedBroadcast(intent, null);
            }
        });
        title.Titleoperation(new TitleLayout.Advance() {
            @Override
            public void onadvance() {
                startActivity(new Intent(WangluoActivity.this,BendiguangboActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        unregisterReceiver(networkchangereceive);
    }

    class NetworkChangeReceive extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //ConnectivityManager专门管理网络的系统服务类
            ConnectivityManager systemService = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                Toast.makeText(WangluoActivity.this, "链接网络", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(WangluoActivity.this, "断开网络", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
