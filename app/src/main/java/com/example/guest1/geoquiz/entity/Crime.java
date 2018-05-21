package com.example.guest1.geoquiz.entity;
/*
 *  项目名: GeoQuiz
 *  包名:   com.example.guest1.geoquiz.entity
 *  文件名: Crime
 *  创建者: yuhaofeng
 *  描述:   todo
 */

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspect;
    private int mRequiresPolices;

    private static final int REQUIRE_POLICES = 1;
    private static final int UNREQUIRE_POLICES = 2;



    public Crime(UUID id){
        mId = id;
        mDate = new Date();
    }

    public Crime(){
        this(UUID.randomUUID());
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public int getRequiresPolices() {
        return mRequiresPolices;
    }

    public void setRequiresPolices(int requiresPolices) {
        mRequiresPolices = requiresPolices;
    }


    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }
}
