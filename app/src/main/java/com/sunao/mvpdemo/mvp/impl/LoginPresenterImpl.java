package com.sunao.mvpdemo.mvp.impl;

import android.text.TextUtils;

import com.sunao.mvpdemo.bean.UserBean;
import com.sunao.mvpdemo.mvp.LoginModel;
import com.sunao.mvpdemo.mvp.LoginPresenter;
import com.sunao.mvpdemo.mvp.LoginView;
import com.sunao.mvpdemo.mvp.OnLoginListener;

/**
 * Created by yuankundong on 2016/03/03.
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginListener {
    LoginView loginView;
    LoginModel loginModel;
    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();

    }
    @Override
    public void actionLogin() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();
        if (TextUtils.isEmpty(username)) {
            loginView.showMessage("用户名为空");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            loginView.showMessage("密码为空");
            return;
        }
        loginView.showProgress();
        loginModel.toLogin(username,password,this);
    }

    @Override
    public void OnSuccess(UserBean userBean) {
        loginView.hideProgress();
        loginView.loginSuccess();
    }

    @Override
    public void OnError(int code, String msg) {
        loginView.hideProgress();
        loginView.loginError(msg);
    }
}
