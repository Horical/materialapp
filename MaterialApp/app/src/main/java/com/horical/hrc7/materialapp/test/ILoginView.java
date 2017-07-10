package com.horical.hrc7.materialapp.test;

import com.horical.hrc7.components.LoginView;

public interface ILoginView {

    void toast(String s);

    interface Handler extends LoginView.Listener {

        @Override
        void onLoginClicked();
    }
}