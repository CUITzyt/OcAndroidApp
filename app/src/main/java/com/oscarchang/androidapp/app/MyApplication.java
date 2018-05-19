package com.oscarchang.androidapp.app;

import android.app.Application;

/**
 * Created by OscarChang on 2018/4/15.
 */
public class MyApplication extends Application {

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static MyApplication getInstance(){
        return mInstance;
    }
}
