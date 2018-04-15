package com.oscarchang.androidapp.picsView;

import com.oscarchang.androidapp.comm.MyLog;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by OscarChang on 2018/4/4.
 */
public class NetService {

    public static InputStream getInputStreamByUrl(String url){
        InputStream mInput = null;
        URL mUrl = null;
        HttpURLConnection murlConnection = null;

        try {
            mUrl = new URL(url);
            murlConnection = (HttpURLConnection)mUrl.openConnection();
            murlConnection.setConnectTimeout(5 * 1000);
            murlConnection.setRequestMethod("GET");
            mInput = murlConnection.getInputStream();
        } catch (MalformedURLException e) {
            MyLog.i(" doInBackground not null ++1 ");
            mInput = null;
            e.printStackTrace();
        } catch (IOException e) {
            MyLog.i(" doInBackground not null ++2");
            mInput = null;
            e.printStackTrace();
        }
        return mInput;
    }
}
