package com.xuexi1.zz.xuexi1;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018-03-10.
 */

public class TranslateAnimationActivity extends BaesActicity {
    @BindView(R.id.i1)
    ImageButton i1;
    @BindView(R.id.i2)
    ImageButton i2;
    @BindView(R.id.i3)
    ImageButton i3;
    @BindView(R.id.i4)
    ImageButton i4;
    @BindView(R.id.i5)
    ImageButton i5;
    int pd = 0;

    Handler handler = new Handler(){
        public AnimatorSet animatorSet9;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    if(pd == 0){
                        float s=i1.getTranslationX();
                        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(i1, "translationX",s,-50f,-50f );
                        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(i1, "alpha", 1f, 0.5f);
                        animatorSet9=new AnimatorSet();
                        animatorSet9.playTogether(objectAnimator,objectAnimator3);
                        animatorSet9.setDuration(500);
                        animatorSet9.start();
                        handler.sendEmptyMessageDelayed(2,2000);
                    }else if(pd == 1){
                        animatorSet9.cancel();
                        handler.getLooper().quit();
                        float s=i1.getTranslationX();
                        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(i1, "translationX",s,-50f,-50f );
                        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(i1, "alpha", 1f, 1f);
                        AnimatorSet animatorSet=new AnimatorSet();
                        animatorSet.playTogether(objectAnimator,objectAnimator3);
                        animatorSet.setDuration(500);
                        animatorSet.start();
                        //handler.sendEmptyMessageDelayed(2,2000);
                    }

                    break;
                case 2:
                    if(pd == 0){
                        float s1=i1.getTranslationX();
                        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(i1, "translationX",s1,-50f,-50f );
                        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(i1, "alpha", 0.5f, 0f);
                        AnimatorSet animatorSet1=new AnimatorSet();
                        animatorSet1.playTogether(objectAnimator1,objectAnimator2);
                        animatorSet1.setDuration(500);
                        animatorSet1.start();
                        handler.sendEmptyMessageDelayed(3,100);
                    }
                    break;
                case 3:
                    if(pd == 0){
                        float s2=i1.getTranslationX();
                        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(i1, "translationX",s2,0f,0f );
                        ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(i1, "alpha", 0f, 0f);
                        AnimatorSet animatorSet2=new AnimatorSet();
                        animatorSet2.playTogether(objectAnimator4,objectAnimator5);
                        animatorSet2.setDuration(500);
                        animatorSet2.start();
                        handler.sendEmptyMessageDelayed(4,1000);
                    }
                    break;
                case 4:
                    if(pd == 0){

                        ObjectAnimator objectAnimator7 = ObjectAnimator.ofFloat(i1, "alpha", 0f, 1f);
                        objectAnimator7.setDuration(500);
                        objectAnimator7.start();

                        //handler.sendEmptyMessageDelayed(4,2000);
                        break;
                    }



            }
        }
    } ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.i1, R.id.i2, R.id.i3, R.id.i4, R.id.i5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.i1:
                if(pd == 0){
                    float s=i1.getTranslationX();
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(i1, "translationX",s,-50f,-50f );
                    ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(i1, "rotation", 0f, 360f);
                    ObjectAnimator objectAnimator10 = ObjectAnimator.ofFloat(i1, "alpha", 0.5f, 1f);
                    AnimatorSet animatorSet=new AnimatorSet();
                    animatorSet.playTogether(objectAnimator,objectAnimator3,objectAnimator10);
                    animatorSet.setDuration(500);
                    animatorSet.start();



                    i2.setVisibility(View.VISIBLE);
                    float s1=i2.getTranslationX();
                    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(i2, "translationX",s1,-80f,-80f );
                    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(i2, "translationY", s1, 100f, 100f);
                    AnimatorSet animatorSet1=new AnimatorSet();
                    animatorSet1.playTogether(objectAnimator1,objectAnimator2);
                    animatorSet1.setDuration(200);
                    animatorSet1.start();

                    i3.setVisibility(View.VISIBLE);
                    float s3=i2.getTranslationX();
                    ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(i3, "translationX",s3,-150f,-150f );
                    ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(i3, "translationY", s3, 0f, 0f);
                    AnimatorSet animatorSet2=new AnimatorSet();
                    animatorSet2.playTogether(objectAnimator4,objectAnimator5);
                    animatorSet2.setDuration(200);
                    animatorSet2.start();

                    i4.setVisibility(View.VISIBLE);
                    float s4=i2.getTranslationX();
                    ObjectAnimator objectAnimator6 = ObjectAnimator.ofFloat(i4, "translationX",s4,-80f,-80f );
                    ObjectAnimator objectAnimator7 = ObjectAnimator.ofFloat(i4, "translationY", s4, -100f, -100f);
                    AnimatorSet animatorSet3=new AnimatorSet();
                    animatorSet3.playTogether(objectAnimator6,objectAnimator7);
                    animatorSet3.setDuration(200);
                    animatorSet3.start();

                    pd = 1;
                } else if(pd == 1){
                    float s=i1.getTranslationX();
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(i1, "translationX",s,-50f,-50f );
                    ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(i1, "rotation", 0f, 360f);
                    AnimatorSet animatorSet=new AnimatorSet();
                    animatorSet.playTogether(objectAnimator,objectAnimator3);
                    animatorSet.setDuration(500);
                    animatorSet.start();

                    float s1=i2.getTranslationX();
                    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(i2, "translationX",s1,0f,0f );
                    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(i2, "translationY", s1, 0f, 0f);
                    AnimatorSet animatorSet1=new AnimatorSet();
                    animatorSet1.playTogether(objectAnimator1,objectAnimator2);
                    animatorSet1.setDuration(200);
                    animatorSet1.start();
                    i2.setVisibility(View.GONE);

                    float s3=i2.getTranslationX();
                    ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(i3, "translationX",s3,0f,0f );
                    ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(i3, "translationY", s3, 0f, 0f);
                    AnimatorSet animatorSet2=new AnimatorSet();
                    animatorSet2.playTogether(objectAnimator4,objectAnimator5);
                    animatorSet2.setDuration(200);
                    animatorSet2.start();
                    i3.setVisibility(View.GONE);

                    float s4=i2.getTranslationX();
                    ObjectAnimator objectAnimator6 = ObjectAnimator.ofFloat(i4, "translationX",s4,0f,0f );
                    ObjectAnimator objectAnimator7 = ObjectAnimator.ofFloat(i4, "translationY", s4, 0f, 0f);
                    AnimatorSet animatorSet3=new AnimatorSet();
                    animatorSet3.playTogether(objectAnimator6,objectAnimator7);
                    animatorSet3.setDuration(200);
                    animatorSet3.start();
                    i4.setVisibility(View.GONE);
                    pd = 0;
                   // handler.sendEmptyMessageAtTime(1,5000);


                        handler.sendEmptyMessageDelayed(1,200);

                }


                /*i5.setVisibility(View.VISIBLE);
                float s5=i2.getTranslationX();
                ObjectAnimator objectAnimator8 = ObjectAnimator.ofFloat(i5, "translationX",s1,-100f,-100f );
                ObjectAnimator objectAnimator9 = ObjectAnimator.ofFloat(i5, "translationY", s1, 40f, 40f);
                AnimatorSet animatorSet4=new AnimatorSet();
                animatorSet4.playTogether(objectAnimator1,objectAnimator2);
                animatorSet4.setDuration(20);
                animatorSet4.start();*/
                Toast.makeText(TranslateAnimationActivity.this,"111",Toast.LENGTH_LONG).show();

                break;
            case R.id.i2:
                Toast.makeText(TranslateAnimationActivity.this,"222",Toast.LENGTH_LONG).show();
                break;
            case R.id.i3:
                Toast.makeText(TranslateAnimationActivity.this,"333",Toast.LENGTH_LONG).show();

                break;
            case R.id.i4:
                Toast.makeText(TranslateAnimationActivity.this,"444",Toast.LENGTH_LONG).show();
                break;
            case R.id.i5:
                break;
        }
    }
}
