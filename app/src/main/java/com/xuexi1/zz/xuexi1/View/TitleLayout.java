package com.xuexi1.zz.xuexi1.View;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xuexi1.zz.xuexi1.R;

import java.net.InterfaceAddress;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018-03-01.
 */

public class TitleLayout extends LinearLayout {
  //  @BindView(R.id.title_back)
    Button titleBack;
    //@BindView(R.id.title_text)
    TextView titleText;
  //  @BindView(R.id.tetle_edit)
    Button tetleEdit;
    Context context;
    private Advance advance;


    public TitleLayout(Context context) {
        super(context);
    }

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.title, this);
        tetleEdit = findViewById(R.id.tetle_edit);
        titleText = findViewById(R.id.title_text);
        tetleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                advance.onadvance();
            }
        });
    }
    public interface Advance{
        void onadvance();
    }
    public void Titleoperation(Advance advance){
       this.advance = advance;
    }
    public void addname(String name){
        titleText.setText(name);
    }
    @OnClick({R.id.title_back, R.id.tetle_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                Log.d("测试2","测试2");
                ((Activity)getContext()).finish();
                break;
            case R.id.tetle_edit:
                Toast.makeText(context,"前进",Toast.LENGTH_SHORT).show();
                break;
        }
    }



  /*  public TitleLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TitleLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }*/
}
