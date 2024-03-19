package com.test.blemonitor;

import android.app.Application;

import com.test.blemonitor.data.SharePref;

public class MyApplication extends Application {

    public static SharePref sharePref;

    @Override
    public void onCreate() {
        super.onCreate();
        sharePref=SharePref.getInstance(this);
    }
}
