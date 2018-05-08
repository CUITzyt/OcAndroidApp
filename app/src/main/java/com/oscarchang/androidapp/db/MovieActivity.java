package com.oscarchang.androidapp.db;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.oscarchang.androidapp.R;
import com.oscarchang.androidapp.comm.DataUtil;
import com.oscarchang.androidapp.comm.FileUtil;
import com.oscarchang.androidapp.comm.MyLog;
import com.oscarchang.androidapp.net.NetUtil;

/**
 * Created by SDT13976 on 2018/4/19.
 */
public class MovieActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_main_layout);

        parseJson();
    }

    private void parseJson() {
        Thread getJsonStrThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String jsonStr = FileUtil.streamToString(NetUtil.getInputStreamByUrl(DataUtil.getJsonFilePath()));
                MyLog.i(" jsonStr is " + jsonStr);
            }
        });
        getJsonStrThread.start();
    }

}
