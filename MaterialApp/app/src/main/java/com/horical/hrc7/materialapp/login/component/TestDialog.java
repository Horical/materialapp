package com.horical.hrc7.materialapp.login.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.lib_base.dialog.BaseDialog;
import com.horical.hrc7.materialapp.R;

/**
 * Created by HRC7 on 6/29/2017.
 */

@MyLayout(R.layout.dialog_test)
public class TestDialog extends BaseDialog<String> {
    @ViewChild(R.id.dialog)
    TextView name;

    public TestDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onBind(String item) {
        name.setText(item);
    }
}
