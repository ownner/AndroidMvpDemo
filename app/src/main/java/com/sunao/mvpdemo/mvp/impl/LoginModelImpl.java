package com.sunao.mvpdemo.mvp.impl;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sunao.mvpdemo.BaseApplication;
import com.sunao.mvpdemo.MD5Utils;
import com.sunao.mvpdemo.bean.UserBean;
import com.sunao.mvpdemo.mvp.LoginModel;
import com.sunao.mvpdemo.mvp.OnLoginListener;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuankundong on 2016/03/03.
 */
public class LoginModelImpl implements LoginModel{

    String url = "http://xxxxx";
    public final static int TIME_OUT_CODE = 99;
    public final static String TIME_OUT_MSG = "网络连接不可用，请稍后重试";
    @Override
    public void toLogin(final String username, final String password, final OnLoginListener onLoginListener) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                Type type = new TypeToken<UserBean>() {
                }.getType();
                Gson gson = new Gson();
                UserBean userBean = gson.fromJson(response, type);
                if (userBean.isSuccess()) {
                    onLoginListener.OnSuccess(userBean);
                } else {
                    onLoginListener.OnError(userBean.getCode(), userBean.getMsg());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onLoginListener.OnError(TIME_OUT_CODE, TIME_OUT_MSG);
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("phone", username);
                map.put("password", MD5Utils.stringToMD5(password));
                return map;
            }
        };
        BaseApplication.requestQueue.add(stringRequest);


    }
}
