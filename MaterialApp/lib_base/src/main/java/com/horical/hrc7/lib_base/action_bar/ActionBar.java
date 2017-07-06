package com.horical.hrc7.lib_base.action_bar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

import com.horical.hrc7.lib_base.R;

/**
 * Created by HRC7 on 7/3/2017.
 */

public class ActionBar extends Toolbar {
    public ActionBar(@NonNull Context context) {
        super(context);
        onInit();
    }


    public ActionBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        onInit();
    }

    public ActionBar(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInit();
    }

    private void onInit() {
        final TypedArray styledAttributes = getContext().getTheme().obtainStyledAttributes(
                new int[]{android.R.attr.actionBarSize, android.R.attr.colorPrimary});
        setMinimumHeight((int) styledAttributes.getDimension(0, 0));
        setBackgroundColor(styledAttributes.getColor(1, Color.GRAY));
        setPopupTheme(R.style.ThemeOverlay_AppCompat_Light);
        styledAttributes.recycle();
    }
}
