package com.oscarchang.androidapp.picsView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.oscarchang.androidapp.R;
import com.oscarchang.androidapp.comm.DataUtil;

import java.util.ArrayList;

import com.oscarchang.androidapp.adapter.ListViewAdapter;

/**
 * Created by OscarChang on 2018/3/30.
 */
//ListView RecycleView to load pictures
public class ViewActivity extends Activity {

    private ListView mListView;
    private ListViewAdapter mAdapter;
    private Context mContext;
    private ArrayList<String> picNames, secondLoadPaths;
    private static final int PICS_LEN = 5;
    private Button actBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewactivity);
        mContext = this;

        initView();
        initData();
        initEvents();
    }

    private void initData() {
        picNames = new ArrayList<String>();
        for (int i = 0; i < PICS_LEN; i++) {
            picNames.add(DataUtil.getDownPicPath(i + 1));
        }

        for (int j = 6; j < 10; j++) {
            secondLoadPaths = new ArrayList<String>();
            secondLoadPaths.add(DataUtil.getDownPicPath(j));
        }
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.lst_pic);
        actBtn = (Button) findViewById(R.id.btn_act);
    }

    private void initEvents() {
        mAdapter = new ListViewAdapter(mContext, picNames);
        mListView.setAdapter(mAdapter);

        actBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.refreshUI();
            }
        });
    }

}
