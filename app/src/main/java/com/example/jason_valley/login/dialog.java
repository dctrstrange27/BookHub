package com.example.jason_valley.login;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.jason_valley.R;

public class dialog extends Dialog{

    public dialog (@NonNull Context context){
        super(context);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER_HORIZONTAL;
        getWindow().setAttributes(params);
        setCancelable(false);
        setTitle(null);
        View view = LayoutInflater.from(context).inflate(R.layout.loading_dialog,null);
        setContentView(view);
    }



}
