package com.oscarchang.androidapp;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by SDT13976 on 2018/4/12.
 */
public class MyApplication extends Application{

    private static MyApplication mInstance;
    private RefWatcher mRefWatcher;

    public RefWatcher getmRefWatcher(){
        return  mRefWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mRefWatcher = LeakCanary.install(this);
    }

    public static MyApplication getInstance(){
        return mInstance;
    }
}
