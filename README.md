# KsyunPlayer
基于金山云播放器封装

##### 引用方式:

```java
allprojects {
 repositories {
   ...
      maven { url 'https://www.jitpack.io' }
   }
 }
```

```java
dependencies {
 implementation 'com.github.W252016021:KsyunPlayer:v1.0'
}
```
##### 调用播放:

```java
new KsyunPlayer(MainActivity.this)
    .setTitle("疯狂的麦克斯4：狂暴之路")
    .setUrl("http://192.168.0.108/20190511/2484_50d77f95/神盾局特工.06E01.mp4")
    .setRequestCode(2019)//2019用于回调播放完成事件，可空
    .setVideoScalingMode(KsyunPlayer.FIT_CENTER)
    .start();
                        

@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
 super.onActivityResult(requestCode, resultCode, data);
 Log.e("info", "onActivityResult: requestCode->" + requestCode + "|resultCode->" + resultCode);
 if (requestCode == 2019) {
    Toast.makeText(this, "播放完毕", Toast.LENGTH_SHORT).show();
   }
}

```
##### 混淆规则:
```java
-keep class com.ksyun.media.player.**{ *; }
-keep class com.ksy.statlibrary.**{ *;}
```

![演示图片](https://raw.githubusercontent.com/W252016021/MyAplayer/master/ScreenShots/Screenshot_20190615-182732.jpg "演示图片")
![演示图片](https://raw.githubusercontent.com/W252016021/MyAplayer/master/ScreenShots/Screenshot_20190615-182748.jpg "演示图片")
![演示图片](https://raw.githubusercontent.com/W252016021/MyAplayer/master/ScreenShots/Screenshot_20190615-182752.jpg "演示图片")

