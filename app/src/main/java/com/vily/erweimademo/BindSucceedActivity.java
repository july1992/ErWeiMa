package com.vily.erweimademo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * description :   扫描别人二维码后  跳转的页面
 * Author : Vily
 * Date : 2018/03/15
 * Time : 11:38
 */

public class BindSucceedActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.actvity_succeed);

        ImageView iv_icon = findViewById(R.id.iv_icon);
        TextView tv_name = findViewById(R.id.tv_name);

        String data = getIntent().getStringExtra("data");

//        User user = JSON.parseObject(data, User.class);
        iv_icon.setImageResource(R.mipmap.ic_launcher);
        tv_name.setText(data);

    }
}
