package com.horical.hrc7.lib_base.custom_view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.view.View;

import com.horical.hrc7.lib_base.helper.finder.StyleableFinder;

/**
 * Created by HRC7 on 7/6/2017.
 */

public abstract class BaseView extends View {
    public BaseView(Context context) {
        super(context);
        onInit(null);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        onInit(attrs);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInit(attrs);
    }

    protected void onInit(AttributeSet attrs) {
        try {
            StyleableFinder.load(this, attrs);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
