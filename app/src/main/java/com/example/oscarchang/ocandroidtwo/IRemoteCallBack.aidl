// IRemoteCallBack.aidl
package com.example.oscarchang.ocandroidtwo;

// Declare any non-default types here with import statements

interface IRemoteCallBack {

    int getActivitySum(in int a ,in int b);
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
