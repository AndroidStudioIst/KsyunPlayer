package com.fucker.ksyunplayer;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ksyun.player.KsyunPlayer;
import com.ksyun.player.KsyunUtils;
import com.ksyun.player.KsyunVodActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.test).setOnClickListener(v -> new KsyunPlayer(MainActivity.this)
                .setTitle("蜘蛛侠：英雄远征")
                .setUrl("http://xunlei.xiazai-zuida.com/1906/ZZX：英雄远征.HDTC中字版.mp4")
                .setRequestCode(2019)
                .setVideoScalingMode(KsyunPlayer.FIT_CENTER)
                /*.setPlayableRangeStart(0)
                .setPlayableRangeEnd(300000)
                .setLive(true)*/
                .start());/*设置试看时间，毫秒，设置为直播模式则不自动记忆播放*/
        //KsyunUtils.loadVideoThumbAsync("/storage/emulated/0/Android/data/com.hammer.tools/files/download/0091BF3331E5E53F3D5E51BB243B74A5/千与千寻.BD1280高清中字版.mp4", 200, (ImageView) findViewById(R.id.thumb));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2019) {
            Toast.makeText(this, "播放完毕", Toast.LENGTH_SHORT).show();
        }
    }
}
