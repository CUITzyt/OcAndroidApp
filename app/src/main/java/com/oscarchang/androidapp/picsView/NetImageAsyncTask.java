package com.oscarchang.androidapp.picsView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import com.oscarchang.androidapp.comm.MyLog;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by OscarChang on 2018/4/4.
 */
public class NetImageAsyncTask extends AsyncTask {

    private String netImageAddress;
    private PostImage postImage;

    public NetImageAsyncTask(String address, PostImage postImage) {
        this.postImage = postImage;
        this.netImageAddress = address;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
//        Drawable resultBitmap = (Drawable) o;
//        if (resultBitmap != null && postImage != null) {
//            postImage.postImage(resultBitmap);
//        }
        Bitmap resultBitmap = (Bitmap) o;
        if (resultBitmap != null && postImage != null) {
            postImage.postImage(resultBitmap);
        }
    }

    @Override
    protected Object doInBackground(Object[] params) {
        //net to bitmap
        InputStream inputStream = NetService.getInputStreamByUrl((String) (params[0]));
        MyLog.i(" doInBackground and params[0] is  " + params[0]);
        if (inputStream != null) {
            MyLog.i(" doInBackground not null ");
            return BitmapFactory.decodeStream(new BufferedInputStream(inputStream));
        }
        MyLog.i(" doInBackground is null ");

        //net to drawable
//        try {
//            Drawable drawable = Drawable.createFromStream(new URL(
//                    netImageAddress).openStream(), "");
//
//            return drawable;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return null;
    }

}
