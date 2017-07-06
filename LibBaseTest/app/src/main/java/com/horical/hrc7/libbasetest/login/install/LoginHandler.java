package com.horical.hrc7.libbasetest.login.install;


import com.horical.hrc7.lib_base.base.BaseHandler;
import com.horical.hrc7.libbasetest.login.ILoginServe;
import com.horical.hrc7.libbasetest.login.ILoginView;

public class LoginHandler extends BaseHandler<ILoginView, ILoginServe> implements ILoginView.Handler, ILoginServe.Handler {
    @Override
    protected void onInit() {

    }
}