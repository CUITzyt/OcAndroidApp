// IRemoteService.aidl
package com.example.oscarchang.ocandroidtwo;
import com.example.oscarchang.ocandroidtwo.Book;
import com.example.oscarchang.ocandroidtwo.IRemoteCallBack;
// Declare any non-default types here with import statements

interface IRemoteService {

    List<Book> getBooks();

    int getPid();

    void registerCallBack(IRemoteCallBack cb);

    void unregisterCallBack(IRemoteCallBack cb);

    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
