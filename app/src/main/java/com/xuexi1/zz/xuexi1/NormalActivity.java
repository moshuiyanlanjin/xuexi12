package com.xuexi1.zz.xuexi1;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xuexi1.zz.xuexi1.View.TitleLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018-02-28.
 */

public class NormalActivity extends BaesActicity {
    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.jiazai)
    ProgressBar jiazai;
    @BindView(R.id.fis)
    Button fis;
    @BindView(R.id.dialog)
    Button dialog;
    @BindView(R.id.pressdialog)
    Button pressdialog;
    @BindView(R.id.titkenor)
    TitleLayout titkenor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        ButterKnife.bind(this);
        Activitycollector.addActivity(this);
        initView();
    }

    int jd = 0;

    private void initView() {
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
        fis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (jd == 100) {
                    if (jiazai.getVisibility() == View.GONE) {
                        jiazai.setVisibility(View.VISIBLE);
                        jd = 0;
                        jiazai.setProgress(jd);
                    } else if (jiazai.getVisibility() == View.VISIBLE) {
                        jiazai.setVisibility(View.GONE);
                    }
                } else {
                    jd = jiazai.getProgress();
                    jd = jd + 10;
                    jiazai.setProgress(jd);
                }
            }
        });
        titkenor.Titleoperation(new TitleLayout.Advance() {
            @Override
            public void onadvance() {
                Intent intent = new Intent(NormalActivity.this,StateFragmentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Activitycollector.removeActivity(NormalActivity.this);
    }

    @OnClick({R.id.dialog, R.id.pressdialog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dialog:
                AlertDialog.Builder dialogA = new AlertDialog.Builder(NormalActivity.this);
                dialogA.setTitle("删除");
                dialogA.setMessage("是否结束app");
                dialogA.setCancelable(false);
                dialogA.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("确定","确定");
                        dialog.dismiss();
                    }
                });
                dialogA.setNegativeButton("取消",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.d("取消","取消");
                    dialog.dismiss();
                }
            });
                dialogA.show();
                break;
            case R.id.pressdialog:
                ProgressDialog progressdialog = new ProgressDialog(NormalActivity.this);
                progressdialog.setTitle("加载中");
                progressdialog.setMessage("正在加载中");
                progressdialog.setCancelable(true);
                progressdialog.show();
                break;
        }
    }
}
