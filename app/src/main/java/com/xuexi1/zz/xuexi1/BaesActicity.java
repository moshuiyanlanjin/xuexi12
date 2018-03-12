package com.xuexi1.zz.xuexi1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Administrator on 2018-02-28.
 */

public class BaesActicity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("活动名：",getClass().getSimpleName());
        //系统自带标题栏
        ActionBar actionBar = getSupportActionBar();
        //去掉系统自带标题栏
        if(actionBar!=null){
            actionBar.hide();
        }
        Activitycollector.addActivity(this);
        initView();
        initDate();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    private void initDate() {

    }

    private void initView() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Activitycollector.removeActivity(this);
    }
}
