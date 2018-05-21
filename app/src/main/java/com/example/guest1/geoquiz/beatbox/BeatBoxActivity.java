package com.example.guest1.geoquiz.beatbox;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest1.geoquiz.SingleFragmentActivity;
import com.example.guest1.geoquiz.fragment.BeatBoxFragment;

public class BeatBoxActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
      try{
          Fragment f =  BeatBoxFragment.newInstance();
          return f;
      }catch (Exception e){
          e.printStackTrace();
          return null;
      }

    }
}
