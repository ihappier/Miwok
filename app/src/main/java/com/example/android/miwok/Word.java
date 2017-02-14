package com.example.android.miwok;

/**
 * Created by ihappier on 2016/12/22.
 */

public class Word {
    private String mMiwok;
    private String mEnglish;
    private int mSoundId;
    private int mImageId = NO_IMAGE;
    private static final int NO_IMAGE = -1;
    public Word(String miwok, String english, int sound_id){
        mMiwok = miwok;
        mEnglish = english;
        mSoundId = sound_id;
    }
    //构造Word类，需要miwok词，英语单词， 以及对应的图片ID
    public Word(String miwok, String english, int image_id, int sound_id){
        mMiwok = miwok;
        mEnglish = english;
        mImageId = image_id;
        mSoundId = sound_id;
    }

    public String getMiwok(){
        return mMiwok;
    }

    public String getEnglish(){
        return mEnglish;
    }

    public int getImageId(){
        return mImageId;
    }

    public int getSoundId(){return mSoundId;}

    public boolean hasImage(){
        return mImageId != NO_IMAGE;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mMiwok='" + mMiwok + '\'' +
                ", mEnglish='" + mEnglish + '\'' +
                ", mSoundId=" + mSoundId +
                ", mImageId=" + mImageId +
                '}';
    }
}
