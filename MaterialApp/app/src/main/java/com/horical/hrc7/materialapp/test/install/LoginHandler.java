package com.horical.hrc7.materialapp.test.install;


import com.horical.hrc7.lib_base.base.BaseHandler;
import com.horical.hrc7.materialapp.test.ILoginServe;
import com.horical.hrc7.materialapp.test.ILoginView;

public class LoginHandler extends BaseHandler<ILoginView, ILoginServe> implements ILoginView.Handler, ILoginServe.Handler {
    @Override
    protected void onInit() {

    }

    @Override
    public void onLoginClicked() {
        getView().toast("Login Clicked");
    }
}