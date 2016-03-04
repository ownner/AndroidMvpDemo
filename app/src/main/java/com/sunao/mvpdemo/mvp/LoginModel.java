package com.sunao.mvpdemo.mvp;

/**
 * Created by yuankundong on 2016/03/03.
 */
public interface LoginModel {
    void toLogin(String username, String password, OnLoginListener onLoginListener);
}
