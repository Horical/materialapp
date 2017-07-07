package com.horical.hrc7.lib_base.base;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.horical.hrc7.lib_base.helper.finder.ViewFinder;

import java.lang.reflect.InvocationTargetException;


/**
 * Created by Billy Phan on 6/21/2017.
 */
public abstract class BaseActivity<T> extends AppCompatActivity {
    private T handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ViewFinder.load(this);
        setupView();
        try {
            if (!(handler instanceof BaseHandler))
                throw new RuntimeException("Handler not instance of BaseHandler");

            //invoke onInit of serve
            BaseServe.class.getDeclaredMethod("onInit", Intent.class).invoke(((BaseHandler) handler).getServe(), getIntent());

            //invoke onInit of handler
            BaseHandler.class.getDeclaredMethod("onInit").invoke(handler);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract void setupView();

    public T getHandler() {
        return handler;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            // permission was granted, yay! Do the
            // contacts-related task you need to do.
            try {
                BaseHandler.class.getDeclaredMethod("onPermissionsAccepted").invoke(handler);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        } else {

            // permission denied, boo! Disable the
            // functionality that depends on this permission.

            //invoke onPermissionDenied of handler
            try {
                BaseHandler.class.getDeclaredMethod("onPermissionsDenied").invoke(handler);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // other 'case' lines to check for other
    // permissions this app might request

}
