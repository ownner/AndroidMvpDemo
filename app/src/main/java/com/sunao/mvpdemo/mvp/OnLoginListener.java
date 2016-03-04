package com.sunao.mvpdemo.mvp;

import com.sunao.mvpdemo.bean.UserBean;

/**
 * Created by yuankundong on 2016/03/03.
 */
public interface OnLoginListener {

    void OnSuccess(UserBean userBean);

    void OnError(int code, String msg);
}
