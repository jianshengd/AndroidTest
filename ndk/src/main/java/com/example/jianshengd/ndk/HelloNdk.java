package com.example.jianshengd.ndk;

/**
 * Created by Administrator on 2018/8/7
 */
public class HelloNdk {
    static {
        System.loadLibrary("hi-ndk");
    }
    public native String getMaxInt(int first, int second);
}
