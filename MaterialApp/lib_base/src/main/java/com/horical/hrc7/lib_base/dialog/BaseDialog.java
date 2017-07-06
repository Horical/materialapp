package com.horical.hrc7.lib_base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.horical.hrc7.lib_base.helper.finder.ViewFinder;

/**
 * Created by HRC7 on 6/30/2017.
 */

public abstract class BaseDialog<T> extends Dialog {
    private T item;
    public BaseDialog(@NonNull Context context) {
        super(context);
        ViewFinder.load(this);
    }

    public BaseDialog bind(T item) {
        this.item = item;
        onBind(item);
        return this;
    }

    protected abstract void onBind(T item);
}
