package com.example.myapplication;

import android.app.Application;

public class Information extends Application {

    private boolean isLogin = false;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
