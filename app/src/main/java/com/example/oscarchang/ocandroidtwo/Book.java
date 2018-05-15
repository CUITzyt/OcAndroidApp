package com.example.oscarchang.ocandroidtwo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SDT13976 on 2018/5/14.
 */
public class Book implements Parcelable{

    private String name;

    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(price);
    }

    public static final Creator<Book> CREATOR = new Creator<Book>(){

        @Override
        public Book createFromParcel(Parcel source) {
            Book mBook = new Book();
            mBook.setName(source.readString());
            mBook.setPrice(source.readInt());

            return mBook;
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public void readFromParcel(Parcel in){
        name = in.readString();
        price = in.readInt();
    }

//    public Book(Parcel in){
//        name = in.readString();
//        price = in.readInt();
//    }

}
