package com.xuexi1.zz.xuexi1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xuexi1.zz.xuexi1.Adapter.MyRecycleAdapter;
import com.xuexi1.zz.xuexi1.View.TitleLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-02-28.
 */

public class FirstActivity extends BaesActicity {

    @BindView(R.id.butt)
    Button butt;
    @BindView(R.id.title)
    TitleLayout title;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    private List<String> firlist = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        adddata();
        initView();

    }

    private void adddata() {
        Random random = new Random();
        int leth = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<30;i++){
            Log.d("测试4",i+"");
            builder.append("鲜冰夺煮");
            firlist.add(builder.toString());
        }
    }


    private void initView() {

        title.addname("首页");
        title.Titleoperation(new TitleLayout.Advance() {
            @Override
            public void onadvance() {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("测试", "运行");
               /* Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.cnblogs.com/mengdd/p/4595973.html"));
                startActivity(intent);*/
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
             /* Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
                startActivity(intent);*/
            }
        });
       /* LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FirstActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);*/
        StaggeredGridLayoutManager layoutmanager = new StaggeredGridLayoutManager(3,LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(layoutmanager);
        MyRecycleAdapter myRecycleAdapter = new MyRecycleAdapter(firlist);
        recycle.setAdapter(myRecycleAdapter);
        myRecycleAdapter.MyRecycleOnclike(new MyRecycleAdapter.BtOnClite() {
            @Override
            public void onclike(int position) {
                Toast.makeText(FirstActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "remove", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (requestCode == 1) {
                    String se = data.getStringExtra("se");
                    Log.d("测试1=", se);
                }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
