package com.oscarchang.androidapp.messenger;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import com.oscarchang.androidapp.comm.MyLog;

/**
 * Created by SDT13976 on 2018/5/15.
 */
public class MessengerActivity extends Activity {

    private static final int MSG_SUM_CLIENT = 0xff0001;
    private boolean connectedMessenger = false;
    private Messenger messengerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindMessengerService();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(messengerConn);
    }

    private void bindMessengerService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.oscarchang.ocandroidtwo", "com.example.oscarchang.ocandroidtwo.messenger.MessenegerService"));
        intent.setAction("com.oscarchang.messenger");
        bindService(intent, messengerConn, Context.BIND_AUTO_CREATE);
    }

    private Messenger messenger = new Messenger(new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_SUM_CLIENT:
                    MyLog.i(" sum out is " + msg.arg2);
                    break;
            }
        }
    });

    private ServiceConnection messengerConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            connectedMessenger = true;
            messengerService = new Messenger(service);

            sendToMessengerService(1, 2);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            connectedMessenger = false;
            messengerService = null;
        }
    };

    private void sendToMessengerService(int a, int b) {
        Message msgFromClient = Message.obtain(null, MSG_SUM_CLIENT, a, b);
        msgFromClient.replyTo = messenger;
        try {
            messengerService.send(msgFromClient);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
