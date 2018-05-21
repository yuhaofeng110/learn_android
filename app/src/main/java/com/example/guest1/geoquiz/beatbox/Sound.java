package com.example.guest1.geoquiz.beatbox;

/*
 *  项目名: learn_android
 *  包名:   com.example.guest1.geoquiz.beatbox
 *  文件名: Sound
 *  创建者: yuhaofeng
 *  描述:   todo
 */
public class Sound {
    private String mAssetPath;

    private String mName;

    private Integer mSoundId;


    public Sound(String assetPath){
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        mName = filename.replace(".wav","");

    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName(){
        return mName;
    }

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }
}
