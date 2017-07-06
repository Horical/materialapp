package com.horical.hrc7.lib_base.helper;

import android.util.Log;

/**
 * Created by quang.pv on 6/9/2017.
 */

public class MyDebug {
    public static final boolean MY_DEBUG = true;
    private static final String TAG = "MY_DEBUG";

    public static void e(Object object, String message) {
        if (MY_DEBUG) Log.e(TAG, object.getClass().getSimpleName() + " - " + message);
    }

    public static void e(Object object, String format, Object... objs) {
        String message = String.format(object.getClass().getSimpleName() + "__" + format, objs);
        if (MY_DEBUG) Log.e(TAG, message);
    }
}
