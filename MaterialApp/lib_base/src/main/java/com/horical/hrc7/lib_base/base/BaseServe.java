package com.horical.hrc7.lib_base.base;

import android.content.Intent;

/**
 * Created by Billy Phan on 6/21/2017.
 */

public abstract class BaseServe<T> {
    private T handler;

    protected abstract void onInit(Intent intent);

    public T getHandler() {
        return handler;
    }
}
