package com.xuexi1.zz.xuexi1.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
//开机广播
public class BootcompleReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
      //  throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context,"开机了",Toast.LENGTH_SHORT).show();

    }
}
