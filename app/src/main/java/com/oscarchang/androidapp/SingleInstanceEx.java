package com.oscarchang.androidapp;

import android.content.Context;

/**
 * Created by OscarChang on 2018/3/18.
 */
public class SingleInstanceEx {

    private static Context mContext;
    private static SingleInstanceEx mInstance;
    private SingleInstanceEx(Context context){
        mContext = context;
    }

    public static SingleInstanceEx getInstance(Context context){
        if (mContext == null){
            mInstance = new SingleInstanceEx(context);
        }
        return mInstance;
    }
}
