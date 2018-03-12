package com.xuexi1.zz.xuexi1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xuexi1.zz.xuexi1.View.TitleLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-03-05.
 */

public class BendiguangboActivity extends BaesActicity {
    @BindView(R.id.send)
    Button send;
    @BindView(R.id.tetle)
    TitleLayout tetle;

    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter;
    private NetBrodReceive netBrodReceive;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bendiguangbo);
        ButterKnife.bind(this);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        initView();
    }

    private void initView() {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("bendide");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("bendide");
        netBrodReceive = new NetBrodReceive();
        localBroadcastManager.registerReceiver(netBrodReceive, intentFilter);

        tetle.Titleoperation(new TitleLayout.Advance() {
            @Override
            public void onadvance() {
            Intent intent = new Intent(BendiguangboActivity.this,WenjiancunchuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(netBrodReceive);
    }

    class NetBrodReceive extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(BendiguangboActivity.this, "本地", Toast.LENGTH_SHORT).show();
        }
    }
}
