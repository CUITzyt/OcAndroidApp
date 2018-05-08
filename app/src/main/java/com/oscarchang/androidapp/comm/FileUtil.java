package com.oscarchang.androidapp.comm;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by SDT13976 on 2018/4/19.
 */
public class FileUtil {

    public static String streamToString(InputStream mInput){
        String ret = null;
        StringBuffer buffer = new StringBuffer();
        String readLine;
        BufferedReader bufferedReader = null;

        MyLog.i(" mInput is " + (mInput==null));
        bufferedReader = new BufferedReader(new InputStreamReader(mInput));
        try {
            while ((readLine=bufferedReader.readLine())!=null){
                buffer.append(readLine);
            }
            bufferedReader.close();
            ret = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            ret = null;
        }
        return  ret;
    }

    /**
     * @param filePath : download path
     * @author oscarchang
     * @time 2018/4/20 11:12
     * */
    public static void stringToFile(String filePath,String fileName,String content){
        FileOutputStream fos = null;
        File saveFile = new File(filePath,fileName);
        try {
            fos = new FileOutputStream(saveFile);
            byte[] buffer = content.getBytes();
            fos.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
