package com.oscarchang.androidapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by SDT13976 on 2018/4/19.
 */
public class MovieBean implements Parcelable{
    private String name;
    private ArrayList<ActorBean> actors;
    private String year;
    private String director;

    public String getName() {
        return name;
    }

    public ArrayList<ActorBean> getActors() {
        return actors;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActors(ArrayList<ActorBean> actors) {
        this.actors = actors;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeTypedList(actors);
        dest.writeString(year);
        dest.writeString(director);
    }

    public static final Parcelable.Creator<MovieBean> CREATOR = new Creator<MovieBean>() {
        @Override
        public MovieBean createFromParcel(Parcel source) {
            MovieBean movieBean = new MovieBean();
            movieBean.setName(source.readString());
            ArrayList<ActorBean> actorBeans = new ArrayList<ActorBean>();
            source.readTypedList(actorBeans,ActorBean.CREATOR);
            movieBean.setActors(actorBeans);
            movieBean.setDirector(source.readString());
            return movieBean;
        }

        @Override
        public MovieBean[] newArray(int size) {
            return new MovieBean[size];
        }
    };

    public MovieBean(){

    }

}
