package com.oscarchang.androidapp.picsView;

/**
 * Created by OscarChang on 2018/3/30.
 */
public class DataUtil {

    private static final String IMA_PREFIX = "pic_scen";
    private static final String DOWN_PATH_PREFIX = "http://192.168.1.101:8080/test/Pics/";

    public static String getDownPicPath(int num){
        StringBuilder mSb = new StringBuilder();
        mSb.append(DOWN_PATH_PREFIX).append(IMA_PREFIX).append(num).append(".jpg");
        return mSb.toString();
    }
}
