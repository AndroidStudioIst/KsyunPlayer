package com.fucker.ksyunplayer;

import android.app.Application;

import com.simple.spiderman.SpiderMan;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SpiderMan.init(this);
    }
}
