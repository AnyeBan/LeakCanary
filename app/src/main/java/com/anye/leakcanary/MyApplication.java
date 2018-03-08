package com.anye.leakcanary;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by banhe on 2018/3/2.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
