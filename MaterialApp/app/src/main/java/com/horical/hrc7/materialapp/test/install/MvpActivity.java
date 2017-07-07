package com.horical.hrc7.materialapp.test.install;

import android.os.Bundle;

import com.horical.hrc7.components.login.LoginView;
import com.horical.hrc7.lib_base.base.BaseActivity;
import com.horical.hrc7.lib_base.base.anotation.MyHandler;
import com.horical.hrc7.lib_base.base.anotation.MyServe;

import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.materialapp.test.IMvpView;
import com.horical.hrc7.materialapp.R;

@MyHandler(MvpHandler.class)
@MyServe(MvpServe.class)
public class MvpActivity extends BaseActivity<IMvpView.Handler> implements IMvpView {

    @ViewChild(R.id.login)
    LoginView LoginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
    }

    @Override
    protected void setupView() {
        LoginView.Item item = null;
        LoginView.bind(item);
    }
}