package com.horical.hrc7.lib_base.loading;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.horical.hrc7.lib_base.R;

/**
 * Created by HRC7 on 7/3/2017.
 */
public class SpinLoading extends Dialog {

    public static SpinLoading newInstance(Context context) {
        SpinLoading spinLoading;
        spinLoading = new SpinLoading(context);
        return spinLoading;
    }

    public SpinLoading(@NonNull Context context) {
        super(context);
        setContentView(R.layout.spin_loading);
//        setCancelable(false);
    }

}
