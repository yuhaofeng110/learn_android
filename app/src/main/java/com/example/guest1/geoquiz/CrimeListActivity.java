package com.example.guest1.geoquiz;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest1.geoquiz.fragment.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
