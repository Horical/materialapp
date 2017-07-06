package com.horical.hrc7.lib_base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.horical.hrc7.lib_base.helper.finder.ViewFinder;

/**
 * Created by HRC7 on 6/30/2017.
 */

public abstract class BaseDialog<T, K> extends Dialog {
    private T item;
    private K listener;

    public BaseDialog(@NonNull Context context) {
        super(context);
        ViewFinder.load(this);
    }

    public BaseDialog bind(T item) {
        this.item = item;
        onBind(item);
        return this;
    }

    protected K getListener() {
        return listener;
    }

    protected abstract void onBind(T item);
}
