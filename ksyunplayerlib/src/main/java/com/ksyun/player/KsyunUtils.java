package com.ksyun.player;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ksyun.media.player.misc.KSYProbeMediaInfo;

public class KsyunUtils {

    public static void loadVideoThumbToImageView(final String localUrl, final long time, final int bitmapWidth, final ImageView imageView) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                KSYProbeMediaInfo mediaInfo = new KSYProbeMediaInfo();
                final Bitmap bitmap = mediaInfo.getVideoThumbnailAtTime(localUrl, time, bitmapWidth, 0);
                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }

    /*获取本地视频指定位置的缩略图*/
    private static Bitmap getVideoThumb(String localUrl, long targetTime, int bitmapWidth) {
        KSYProbeMediaInfo mediaInfo = new KSYProbeMediaInfo();
        Bitmap bitmap = mediaInfo.getVideoThumbnailAtTime(localUrl, targetTime, bitmapWidth, 0);
        return bitmap;
    }

}
