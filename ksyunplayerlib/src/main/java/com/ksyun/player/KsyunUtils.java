package com.ksyun.player;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.ksyun.media.player.misc.KSYProbeMediaInfo;

public class KsyunUtils {

    public static void loadVideoThumbAsync(final String localUrl, final long time, final int bitmapWidth, final ImageView imageView) {
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


    public static String toMinute(long second) {
        return second % 86400 % 3600 / 60 + "分" + second % 60 + "秒";
    }

    public static String generateTime(long time) {
        int totalSeconds = (int) (time / 1000);
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        return hours > 0 ? String.format("%02d小时%02d分钟%02d秒", hours, minutes, seconds) : String.format("%02d分钟%02d秒", minutes, seconds);
    }
}
