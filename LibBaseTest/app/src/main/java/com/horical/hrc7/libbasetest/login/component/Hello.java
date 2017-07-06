package com.horical.hrc7.libbasetest.login.component;

import android.content.Context;

import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.dialog.BaseDialog;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.libbasetest.R;

/**
 * Created by HRC7 on 6/30/2017.
 */

@MyLayout(R.layout.dialog_hello)
public class Hello extends BaseDialog<User,Object> {
    @ViewChild(R.id.dialog_item)
    TextView textView;


    public Hello(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onBind(User item) {
        textView.setText(item.getName());
    }

    public interface Listener
    {

    }
}