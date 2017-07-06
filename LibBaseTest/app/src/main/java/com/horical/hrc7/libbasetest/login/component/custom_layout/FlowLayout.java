package com.horical.hrc7.libbasetest.login.component.custom_layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by HRC7 on 7/6/2017.
 */

public class FlowLayout extends ViewGroup {
    FlowLayoutManager flowLayoutManager;

    public FlowLayout(Context context) {
        super(context);
        onInit(null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        onInit(attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInit(attrs);
    }

    protected void onInit(AttributeSet attrs) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
    }
}
