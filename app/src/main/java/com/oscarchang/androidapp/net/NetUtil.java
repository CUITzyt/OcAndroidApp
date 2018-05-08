package com.oscarchang.androidapp.net;

import com.oscarchang.androidapp.comm.MyLog;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by OscarChang on 2018/4/4.
 */
public class NetUtil {

    public static InputStream getInputStreamByUrl(String url) {
        InputStream mInput = null;
        URL mUrl = null;
        HttpURLConnection murlConnection = null;

        try {
            mUrl = new URL(url);
            murlConnection = (HttpURLConnection) mUrl.openConnection();
            murlConnection.setConnectTimeout(5 * 1000);
            murlConnection.setReadTimeout(5 * 1000);
            murlConnection.setDoInput(true);
            murlConnection.setDoOutput(false);
            murlConnection.setRequestMethod("GET");
            int responsCode = murlConnection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responsCode) {
                mInput = murlConnection.getInputStream();
            }
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
