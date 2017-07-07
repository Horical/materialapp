package com.horical.hrc7.libbasetest.hola.install;


import com.horical.hrc7.lib_base.base.BaseHandler;
import com.horical.hrc7.libbasetest.hola.IHolaServe;
import com.horical.hrc7.libbasetest.hola.IHolaView;

public class HolaHandler extends BaseHandler<IHolaView, IHolaServe> implements IHolaView.Handler, IHolaServe.Handler {
    @Override
    protected void onInit() {

    }
}