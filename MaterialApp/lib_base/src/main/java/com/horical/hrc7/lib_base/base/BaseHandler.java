package com.horical.hrc7.lib_base.base;

/**
 * Created by Billy Phan on 6/21/2017.
 */

public abstract class BaseHandler<T, K> {
    private T view;
    private K serve;

    protected abstract void onInit();

    public T getView() {
        return view;
    }

    public K getServe() {
        return serve;
    }

    public void onPermissionsAccepted() {

    }

    public void onPermissionsDenied() {

    }
}
