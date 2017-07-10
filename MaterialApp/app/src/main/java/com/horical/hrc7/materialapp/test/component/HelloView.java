package com.horical.hrc7.materialapp.test.component;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.lib_base.helper.finder.ViewFinder;

import com.horical.hrc7.materialapp.R;

import org.w3c.dom.Text;

/**
 * Created by HRC7 on 7/6/2017.
 */

@MyLayout(name = "view_hello_view")
public class HelloView extends FrameLayout {
    String item;
    Listener listener;

    @ViewChild
    TextView custom_text;

    public HelloView(Context context) {
        super(context);
        onInit(null);
    }

    public HelloView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        onInit(attrs);
    }

    public HelloView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInit(attrs);
    }

    private void onInit(AttributeSet attrs) {
        ViewFinder.load(this);
    }

    public void bind(String item) {
        this.item = item;
        custom_text.setText(item);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Item {

    }

    public interface Listener {

    }

}
