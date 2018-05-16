package com.example.guest1.geoquiz.entity;
/*
 *  项目名: GeoQuiz
 *  包名:   com.example.guest1.geoquiz.entity
 *  文件名: Question
 *  创建者: yuhaofeng
 *  描述:   todo
 */

public class Question {
    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int mTextResId, boolean mAnswerTrue) {
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
    }
}
