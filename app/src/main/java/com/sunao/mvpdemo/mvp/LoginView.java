package com.sunao.mvpdemo.mvp;

/**
 * Created by yuankundong on 2016/03/03.
 */
public interface LoginView {

    String getUsername();

    String getPassword();

    void loginSuccess();

    void loginError(String msg);

    void showProgress();

    void hideProgress();

    void showMessage(String msg);
}
