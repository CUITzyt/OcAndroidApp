package com.oscarchang.androidapp.aidl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.oscarchang.ocandroidtwo.Book;
import com.example.oscarchang.ocandroidtwo.IRemoteCallBack;
import com.example.oscarchang.ocandroidtwo.IRemoteService;
import com.oscarchang.androidapp.R;
import com.oscarchang.androidapp.comm.MyLog;

import java.util.List;

/**
 * Created by SDT13976 on 2018/5/15.
 */
public class BindAdilActivity extends Activity {

    private IRemoteService remoteService;
    private List<Book> mBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bindaidl);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent remoteCon = new Intent();
        remoteCon.setComponent(new ComponentName("com.example.oscarchang.ocandroidtwo", "com.example.oscarchang.ocandroidtwo.RemoteService"));
        remoteCon.setAction("com.oscarchang.remote");
        bindService(remoteCon, remoteServiceConn, Context.BIND_AUTO_CREATE);

    }

    private void operateForRemote() {
        try {
            mBooks = remoteService.getBooks();
            remoteService.getPid();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        int bookLen = mBooks.size();
        for (int i = 0; i < bookLen; i++) {
            MyLog.i(mBooks.get(i).getName());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(remoteServiceConn);
    }

    private ServiceConnection remoteServiceConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            remoteService = IRemoteService.Stub.asInterface(service);
            try {
                remoteService.registerCallBack(remoteCallBack);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            MyLog.i(" remoteService is null " + (remoteService == null));
            operateForRemote();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            try {
                remoteService.unregisterCallBack(remoteCallBack);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            remoteService = null;
        }
    };

    private IRemoteCallBack remoteCallBack = new IRemoteCallBack.Stub() {

        @Override
        public int getActivitySum(int a, int b) throws RemoteException {
            MyLog.i(" getActivitySum out is " + (a + b));
            return (a + b);
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            //do nothing
        }
    };
}
