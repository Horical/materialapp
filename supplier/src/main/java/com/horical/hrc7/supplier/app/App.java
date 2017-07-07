package com.horical.hrc7.supplier.app;

import android.app.Application;

/**
 * Created by Billy Phan on 6/21/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppManager.load(this);
    }
}
