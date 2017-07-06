package com.horical.hrc7.libbasetest.login.component.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.horical.hrc7.lib_base.custom_view.BaseView;
import com.horical.hrc7.lib_base.helper.finder.MyAttr;
import com.horical.hrc7.lib_base.helper.finder.StyleableFinder;
import com.horical.hrc7.libbasetest.R;

/**
 * Created by HRC7 on 7/6/2017.
 */

public class BaseCustomView extends BaseView {

    @MyAttr(attr = R.styleable.BaseCustomView_size
            , type = StyleableFinder.DIMENSION)
    float size = 100;

    public BaseCustomView(Context context) {
        super(context);
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onInit(AttributeSet attrs) {
        super.onInit(attrs);
    }
}
