package com.vily.erweimademo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * description :
 * Author : Vily
 * Date : 2018/03/15
 * Time : 11:01
 */

public class MyZXingActivity extends AppCompatActivity{

    private ImageView mIv_icon;
    private TextView mTv_name;
    private ImageView mMy_zxing;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_myzxing);

        mIv_icon = findViewById(R.id.iv_icon);
        mTv_name = findViewById(R.id.tv_name);

        mMy_zxing = findViewById(R.id.my_zxing);

        setMyZXing();
    }

    private void setMyZXing() {
        // 动态生成我的二维码 并写入医生信息(Id)
        int mar = (int) getResources().getDimension(R.dimen.pic);

        User user=new User(123,"张三");

        String content = JSON.toJSONString(user);

        //    R.mipmap.ic_launcher  是要展示在二维码中心的图片
        Bitmap mBitmap = CodeUtils.createImage(content, mar, mar, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        mMy_zxing.setImageBitmap(mBitmap);
    }
}
