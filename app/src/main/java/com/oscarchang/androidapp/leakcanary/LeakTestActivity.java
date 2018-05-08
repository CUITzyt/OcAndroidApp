package com.oscarchang.androidapp.leakcanary;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import com.oscarchang.androidapp.R;
import com.oscarchang.androidapp.MyApplication;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by SDT13976 on 2018/4/19.
 */
public class LeakTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leak_layout);
        TextView textView = (TextView) findViewById(R.id.test_text_view);
        TestDataModel.getInstance().setRetainedTextView(textView);

        RefWatcher watcher = MyApplication.getInstance().getmRefWatcher();
        watcher.watch(this);


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        }).start();

    }
}
