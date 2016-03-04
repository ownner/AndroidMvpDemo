package com.sunao.mvpdemo.bean;

/**
 * Created by yuankundong on 2016/03/03.
 */
public class UserBean {
    private int code;    // 返回码，0为成功
    private String msg;      // 返回信息


    public UserBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return code == 0;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
