package com.horical.hrc7.materialapp.test.install;

import android.os.Bundle;
import android.widget.Toast;

import com.horical.hrc7.components.LoginView;
import com.horical.hrc7.lib_base.base.BaseActivity;
import com.horical.hrc7.lib_base.base.anotation.MyHandler;
import com.horical.hrc7.lib_base.base.anotation.MyServe;

import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.materialapp.test.ILoginView;
import com.horical.hrc7.materialapp.R;

@MyHandler(LoginHandler.class)
@MyServe(LoginServe.class)
public class LoginActivity extends BaseActivity<ILoginView.Handler> implements ILoginView {

    @ViewChild
    LoginView login_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void setupView() {
        login_view.setListener(getHandler());
    }

    @Override
    public void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}