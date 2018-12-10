package com.vily.erweimademo;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * description :
 * Author : Vily
 * Date : 2018/03/15
 * Time : 10:32
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
    }
}
