package com.horical.hrc7.materialapp.test.component;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.horical.hrc7.lib_base.custom_view.BaseView;
import com.horical.hrc7.lib_base.helper.finder.MyAttr;
import com.horical.hrc7.lib_base.helper.finder.StyleableFinder;
import com.horical.hrc7.materialapp.R;

/**
 * Created by HRC7 on 7/6/2017.
 */

public class MyCustomView extends BaseView<MyCustomView.Item, MyCustomView.Listener> {

    @MyAttr(name = "MyCustomView_size"
            , type = StyleableFinder.DIMENSION)
    float size = 100;

    public MyCustomView(Context context) {
        super(context);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onBind(Item item) {

    }

    public interface Item {

    }

    public interface Listener {

    }

}
