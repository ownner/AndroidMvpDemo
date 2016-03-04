package com.sunao.mvpdemo;

import android.app.Application;

import com.android.volley.RequestQueue;

/**
 * Created by yuankundong on 2016/03/03.
 */
public class BaseApplication extends Application{

    public static RequestQueue requestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = VolleySingleton.getVolleySingleton(this).getRequestQueue();
    }
}
