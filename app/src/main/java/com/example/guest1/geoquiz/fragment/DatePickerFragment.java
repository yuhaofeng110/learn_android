package com.example.guest1.geoquiz.fragment;
/*
 *  项目名: GeoQuiz
 *  包名:   com.example.guest1.geoquiz.fragment
 *  文件名: DatePickerFragment
 *  创建者: yuhaofeng
 *  描述:   todo
 */

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.example.guest1.geoquiz.R;

public class DatePickerFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date,null);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok,null)
                .create();
        //return super.onCreateDialog(savedInstanceState);
    }
}
