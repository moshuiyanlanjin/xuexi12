package com.xuexi1.zz.xuexi1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-02-28.
 */

public class DialogActivity extends BaesActicity {
    @BindView(R.id.text1)
    TextView text1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        initView();

    }

    public void initView() {
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activitycollector.finshAll();

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
