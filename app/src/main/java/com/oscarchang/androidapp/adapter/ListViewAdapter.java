package com.oscarchang.androidapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.oscarchang.androidapp.R;
import com.oscarchang.androidapp.comm.DataUtil;
import com.oscarchang.androidapp.comm.MyLog;
import com.oscarchang.androidapp.net.NetImageAsyncTask;
import com.oscarchang.androidapp.picsView.PostImage;

import java.util.ArrayList;

/**
 * Created by OscarChang on 2018/3/30.
 */
public class ListViewAdapter  extends BaseAdapter{

    private ArrayList<String> picNames = new ArrayList<String>();
    private LayoutInflater mInflater;
    private Handler mHandler;

    public ListViewAdapter(Context context, ArrayList<String> mNames){
        picNames = mNames;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return picNames.size();
    }

    @Override
    public Object getItem(int position) {
        return picNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    
    public void setHandler(Handler pHandler){
        this.mHandler = pHandler;
    }

    public void refreshUI(){
        for (int i=6; i<10; i++){
            picNames.add(DataUtil.getDownPicPath(i));
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View pView = convertView;
        if (pView == null){
            holder = new ViewHolder();
            pView = mInflater.inflate(R.layout.list_item,null);
            holder.mImage = (ImageView)pView.findViewById(R.id.lst_item_image);
            holder.mText = (TextView)pView.findViewById(R.id.lst_item_txt);
            pView.setTag(holder);
        }else {
            holder = (ViewHolder)pView.getTag();
        }
        String currentPicPath = picNames.get(position);
        holder.mText.setText(currentPicPath.substring(currentPicPath.lastIndexOf("/") + 1));
        NetImageAsyncTask loadImageTask = new NetImageAsyncTask(currentPicPath,new PostImage() {
            @Override
            public void postImage(Bitmap bitMap) {
                holder.mImage.setImageBitmap(bitMap);
            }
        });
        MyLog.i(" to excute image net ");
        loadImageTask.execute(currentPicPath);
        return pView;
    }

    public class ViewHolder{
        public ImageView mImage;
        public TextView mText;
    }
}
