package com.example.guest1.geoquiz.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/*
 *  项目名: learn_android
 *  包名:   com.example.guest1.geoquiz.beatbox
 *  文件名: SoundViewModel
 *  创建者: yuhaofeng
 *  描述:   todo
 */
public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox){
        mBeatBox = beatBox;
    }

    public Sound getSound() {
        return mSound;
    }

    public void setSound(Sound sound){
        mSound = sound;
        //通知修改
        //notifyPropertyChanged(int);
        notifyChange();
    }

    @Bindable
    public String getTitle(){
        return mSound.getName();
    }


    public void onButtonClicked() {
        Log.d("hahah","af");
        mBeatBox.play(mSound);
        Log.d("hahah","22af");
    }
}
