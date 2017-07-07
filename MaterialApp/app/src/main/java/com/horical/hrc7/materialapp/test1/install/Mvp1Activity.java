package com.horical.hrc7.materialapp.test1.install;

import android.os.Bundle;

import com.horical.hrc7.lib_base.base.BaseActivity;
import com.horical.hrc7.lib_base.base.anotation.MyHandler;
import com.horical.hrc7.lib_base.base.anotation.MyServe;

import com.horical.hrc7.materialapp.test1.IMvp1View;
import com.horical.hrc7.materialapp.R;

@MyHandler(Mvp1Handler.class)
@MyServe(Mvp1Serve.class)
public class Mvp1Activity extends BaseActivity<IMvp1View.Handler> implements IMvp1View {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp1);
    }

    @Override
    protected void setupView() {

    }
}