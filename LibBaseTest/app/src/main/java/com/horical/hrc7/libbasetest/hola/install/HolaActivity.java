package com.horical.hrc7.libbasetest.hola.install;

import android.os.Bundle;

import com.horical.hrc7.lib_base.base.BaseActivity;
import com.horical.hrc7.lib_base.base.anotation.MyHandler;
import com.horical.hrc7.lib_base.base.anotation.MyServe;

import com.horical.hrc7.libbasetest.hola.IHolaView;
import com.horical.hrc7.libbasetest.R;

@MyHandler(HolaHandler.class)
@MyServe(HolaServe.class)
public class HolaActivity extends BaseActivity<IHolaView.Handler> implements IHolaView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola);
    }

    @Override
    protected void setupView() {

    }
}