package com.ksyun.player;

import android.app.Activity;
import android.content.Intent;

public class KsyunPlayer {
    private Activity activity;
    private String title;
    private String url;
    private boolean isLive = false;
    private int videoScalingMode = 1;
    private int requestCode = 10086;
    public static final int FULL_SCREEN_NO_SCALE = 0;//填满屏幕拉伸
    public static final int FIT_CENTER = 1;//居中原比例缩放
    public static final int CENTER_CROP = 2;//居中裁剪全屏

    public KsyunPlayer(Activity activity) {
        this.activity = activity;
    }

    public KsyunPlayer setTitle(String title) {
        this.title = title;
        return this;
    }

    public KsyunPlayer setUrl(String url) {
        this.url = url;
        return this;
    }

    public KsyunPlayer setRequestCode(int requestCode) {
        this.requestCode = requestCode;
        return this;
    }

    public KsyunPlayer setLive(boolean live) {
        isLive = live;
        return this;
    }

    public KsyunPlayer setVideoScalingMode(int videoScalingMode) {
        this.videoScalingMode = videoScalingMode;
        return this;
    }

    public void start() {
        Intent intent = new Intent(activity, KsyunVodActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        intent.putExtra("scale", videoScalingMode);
        intent.putExtra("live", isLive);
        activity.startActivityForResult(intent, requestCode);
    }
}
