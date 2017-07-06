package com.horical.hrc7.materialapp.login.install;


import com.horical.hrc7.lib_base.base.BaseHandler;
import com.horical.hrc7.materialapp.login.ILoginServe;
import com.horical.hrc7.materialapp.login.ILoginView;
import com.horical.hrc7.materialapp.login.view_struct.IUserLogin;

/**
 * Created by Billy Phan on 6/24/2017.
 */

public class LoginHandler extends BaseHandler<ILoginView, ILoginServe> implements ILoginView.Handler, ILoginServe.Handler {
    @Override
    protected void onInit() {
        getServe().loadFormHint();
    }

    @Override
    public void onLoadUserHintFail(String message) {
        getView().toast("Load user hint error " + message);
    }

    @Override
    public void onLoadUserHintSuccess(IUserLogin body) {
        getView().bindHint(body);
    }

    @Override
    public void onLoginClicked() {

    }
}
