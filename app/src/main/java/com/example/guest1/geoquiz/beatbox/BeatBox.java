//资源管理类

package com.example.guest1.geoquiz.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {

    private static final String TAG = "BeatBox";

    private static final String SOUNDS_FOLDER = "sample_sounds";

    private static final int MAX_SOUNDS = 5;

    private SoundPool mSoundPool;


    public void release() {
        mSoundPool.release();
    }
    public List<Sound> getSounds() {
        return mSounds;
    }

    private List<Sound> mSounds = new ArrayList<>();

    private AssetManager mAssets;

    public BeatBox(Context context) {
        mAssets = context.getAssets();
        //第一个参数指定同时播放多少个音频。这里指定了5个。已经播放了5个音频时，如果尝试再 播第6个，SoundPool会停止播放原来的音频。
        //第二个参数确定音频流类型。Android有很多不同的音频流，它们都有各自独立的音量控制 选项。这就是调低音乐音量，闹钟音量却不受影响的原因。打开开发者文档，先找到 AudioManager类中以AUDIO打头的常量，再看看其他控制选项。STREAM_MUSIC是音乐和游戏 常用的音量控制常量
        //最后一个参数指定采样率转换品质。参考文档说这个参数不起作用，所以这里传入0
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC,0);

        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames;
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found " + soundNames.length + " sounds");

        } catch (IOException ioe) {
            Log.e(TAG, "Could not list assets", ioe);
            return;
        }

        for (String filename : soundNames) {

            try {
                String assetPath = SOUNDS_FOLDER + "/" + filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);
            } catch (IOException ioe) {
                Log.e(TAG, "Could not load sound", ioe);
            }

        }

    }

    private void load(Sound sound) throws  IOException{
        //调用mSoundPool.load(AssetFileDescriptor, int)方法可以把文件载入SoundPool待播
        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd,1);
        sound.setSoundId(soundId);
    }

    public void play(Sound sound){
        Integer soundId = sound.getSoundId();
        if (soundId == null){
            Log.d("hahah","nimasle");
            return ;
        }
        //音频ID、左音量、右音量、优先级(无效)、是否循环以及播放速 率。我们需要最大音量和常速播放，所以传入值1.0。是否循环参数传入0，代表不循环。(如果 想无限循环，可以传入1。相信这会异常讨人厌。)
        mSoundPool.play(soundId,1.0f,1.0f,1,0,1.0f);
    }
}
