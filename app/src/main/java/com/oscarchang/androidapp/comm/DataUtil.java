package com.oscarchang.androidapp.comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by OscarChang on 2018/3/30.
 */
public class DataUtil {

    public static final String IMA_PREFIX = "pic_scen";
    public static final String DOWN_PATH_PREFIX_ATHOME = "http://192.168.1.101:8080/test/Pics/";
    public static final String DOWN_PATH_PREFIX_ATCOMPANY = "http://192.168.2.53:8080/oscarchang/";
    public static final String JSON_FILENAME = "movies.json";
    public static final String JSON_PRFIX_DIR = "json/";


    public static String getDownPicPath(int num){
        StringBuilder mSb = new StringBuilder();
        mSb.append(DOWN_PATH_PREFIX_ATHOME).append(IMA_PREFIX).append(num).append(".jpg");
        return mSb.toString();
    }

    public static String getJsonFilePath(){
        StringBuilder mSb = new StringBuilder();
        mSb.append(DOWN_PATH_PREFIX_ATCOMPANY).append(JSON_PRFIX_DIR).append(JSON_FILENAME);
        return mSb.toString();
    }


}
