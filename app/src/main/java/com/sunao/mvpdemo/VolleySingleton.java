/**
 * Copyright (c) 2015 Changchun Sunao Software Co., Ltd. All Rights Reserved
 */
package com.sunao.mvpdemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by yuankundong on 2016/03/03.
 */

public class VolleySingleton {

    private static VolleySingleton volleySingleton;
    private RequestQueue mRequestQueue;
    private Context mContext;
    public VolleySingleton(Context context) {
        this.mContext = context;
        mRequestQueue = getRequestQueue();
    }
    public static synchronized VolleySingleton getVolleySingleton(Context context){
        if(volleySingleton == null){
            volleySingleton = new VolleySingleton(context);
        }
        return volleySingleton;
    }
    public RequestQueue getRequestQueue(){
        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }

}
