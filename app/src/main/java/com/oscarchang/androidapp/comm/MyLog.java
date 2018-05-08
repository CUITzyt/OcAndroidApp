package com.oscarchang.androidapp.comm;

import android.util.Log;

/**
 * Created by OscarChang on 2018/4/4.
 */
public class MyLog {

    private static  String TAG = "";


    public static void i(String content){
        Log.i(TAG,"  ====>>>>  " + content);
    }

    public static void setTAG(String tag) {
        TAG = tag;
    }
}
