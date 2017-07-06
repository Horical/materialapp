package com.horical.hrc7.materialapp.login.component;

import android.content.Context;

import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.dialog.BaseDialog;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.materialapp.R;

/**
 * Created by HRC7 on 6/30/2017.
 */

@MyLayout(R.layout.dialog_meme)
public class MemeDialog extends BaseDialog<String> {
    @ViewChild(R.id.meme)
    TextView meme;

    public MemeDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onBind(String item) {
        meme.setText(item);
    }
}