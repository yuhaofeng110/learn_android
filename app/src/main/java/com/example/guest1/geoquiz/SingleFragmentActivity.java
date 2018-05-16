package com.example.guest1.geoquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/*
 *  项目名: GeoQuiz
 *  包名:   com.example.guest1.geoquiz
 *  文件名: SingleFragmentActivity
 *  创建者: yuhaofeng
 *  描述:   todo
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();
    private static int num = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager  fm = getSupportFragmentManager();
        Fragment  fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null){
            Log.d("nonono", String.valueOf(num++));
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }
    }
}
