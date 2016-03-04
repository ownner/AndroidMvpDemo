package com.sunao.mvpdemo.mvp.impl;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sunao.mvpdemo.R;
import com.sunao.mvpdemo.mvp.LoginPresenter;
import com.sunao.mvpdemo.mvp.LoginView;

/**
 * Created by yuankundong on 2016/03/03.
 */
public class LoginActivity extends AppCompatActivity implements LoginView{
    TextView username;
    TextView password;
    Button login;
    ProgressDialog dialog;
    LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new LoginPresenterImpl(this);
        username = (TextView) findViewById(R.id.tv_username);
        password = (TextView) findViewById(R.id.tv_password);
        login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.actionLogin();
            }
        });


    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        dialog = ProgressDialog.show(this, " ", "加载中", true, true);
    }

    @Override
    public void hideProgress() {
        dialog.dismiss();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
