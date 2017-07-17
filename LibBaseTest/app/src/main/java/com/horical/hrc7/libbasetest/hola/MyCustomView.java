package com.horical.hrc7.libbasetest.hola;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.horical.hrc7.lib_base.custom_view.BaseView;
import com.horical.hrc7.lib_base.helper.MyDebug;
import com.horical.hrc7.lib_base.helper.finder.MyAttr;
import com.horical.hrc7.lib_base.helper.finder.StyleableFinder;
import com.horical.hrc7.lib_base.helper.finder.ViewFinder;
import com.horical.hrc7.libbasetest.R;

/**
 * Created by HRC7 on 7/6/2017.
 */

public class MyCustomView extends FrameLayout {

    @MyAttr(type = StyleableFinder.REFERENCE)
    int size;

    @MyAttr(type = StyleableFinder.REFERENCE)
    int name;

    public MyCustomView(Context context) {
        super(context);
        onInit(null);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        onInit(attrs);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInit(attrs);
    }

    protected void onInit(AttributeSet attrs) {
//        ViewFinder.load(this);
        StyleableFinder.load(this, attrs);

        MyDebug.e(this, "sdfsdf %s", getResources().getString(size));
        MyDebug.e(this, "sdfsdf 1 %s", getResources().getString(name));
    }


}
