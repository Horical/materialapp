package com.horical.hrc7.materialapp.test.component;

import android.content.Context;

import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.dialog.BaseDialog;

import android.support.annotation.NonNull;

import com.horical.hrc7.materialapp.R;

/**
 * Created by HRC7 on 6/30/2017.
 */

@MyLayout(name = "dialog_my_dialog")
public class MyDialog extends BaseDialog<MyDialog.Item, MyDialog.Listener> {

    public MyDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onBind(Item item) {

    }

    public interface Item {

    }

    public interface Listener {
    }
}