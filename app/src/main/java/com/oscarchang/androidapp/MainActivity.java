package com.oscarchang.androidapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.oscarchang.androidapp.comm.MyLog;


public class MainActivity extends ActionBarActivity {

    private Button btnLoadListView;
    private Intent jumpIntent;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        initView();
        initEvents();
    }

    private void initView() {
        btnLoadListView = (Button) findViewById(R.id.btn_listview);
    }

    private void initEvents() {
        btnLoadListView.setOnClickListener(btnClickListener);
        MyLog.setTAG("OscarChang");
    }

    private View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_listview:
                    jumpIntent = new Intent();
                    jumpIntent.setAction("com.oscar.demo.listview");
                    ComponentName jumComponent = new ComponentName("com.third.oscarchang.third", "com.third.oscarchang.third.picsView.ViewActivity");
                    jumpIntent.setComponent(jumComponent);
                    mContext.startActivity(jumpIntent);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
