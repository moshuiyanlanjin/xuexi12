package com.xuexi1.zz.xuexi1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xuexi1.zz.xuexi1.View.TitleLayout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018-03-06.
 */

public class WenjiancunchuActivity extends BaesActicity {
    @BindView(R.id.title)
    TitleLayout title;
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.cun)
    Button cun;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wjcchu);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        //读取
        String loda = Loda();
        edit.setText(loda);
        title.Titleoperation(new TitleLayout.Advance() {
            @Override
            public void onadvance() {
                Intent intent = new Intent(WenjiancunchuActivity.this,ImageActivity.class);
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.cun)
    public void onViewClicked() {
        String trim = edit.getText().toString().trim();
        //存储
        Sava(trim);
        Toast.makeText(WenjiancunchuActivity.this,"",Toast.LENGTH_SHORT).show();
    }

    private String Loda() {
        FileInputStream fileinp = null;
        BufferedReader buffread = null;
        StringBuilder content = new StringBuilder();
        try {
            fileinp = this.openFileInput("data");
            buffread = new BufferedReader(new InputStreamReader(fileinp));
            String line = "";
            while ((line = buffread.readLine())!=null){
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                try {
                    if(buffread !=null) {
                        buffread.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        return content.toString();
    }

    private void Sava(String trim) {
        FileOutputStream fileout = null;
        BufferedWriter buffwriter = null;
        try {
            fileout = this.openFileOutput("data",Context.MODE_PRIVATE);
            buffwriter = new BufferedWriter(new OutputStreamWriter(fileout));
            buffwriter.write(trim);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                try {
                    if(buffwriter!=null) {
                        buffwriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}
