package com.oscarchang.androidapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SDT13976 on 2018/4/20.
 */
public class ActorBean implements Parcelable{

    private String alpha;
    private String beta;

    public String getAlpha() {
        return alpha;
    }

    public String getBeta() {
        return beta;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public void setBeta(String beta) {
        this.beta = beta;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public ActorBean(){

    }

    public static final Parcelable.Creator<ActorBean> CREATOR = new Creator<ActorBean>() {
        @Override
        public ActorBean createFromParcel(Parcel source) {

            ActorBean actorBean = new ActorBean();
            actorBean.setAlpha(source.readString());
            actorBean.setBeta(source.readString());
            return actorBean;
        }

        @Override
        public ActorBean[] newArray(int size) {
            return new ActorBean[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(alpha);
        dest.writeString(beta);
    }
}
