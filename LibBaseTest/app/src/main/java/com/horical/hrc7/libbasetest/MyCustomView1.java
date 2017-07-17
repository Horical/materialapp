package com.horical.hrc7.libbasetest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.horical.hrc7.lib_base.custom_view.BaseView;
import com.horical.hrc7.lib_base.helper.finder.MyAttr;
import com.horical.hrc7.lib_base.helper.finder.StyleableFinder;

/**
 * Created by HRC7 on 7/6/2017.
 */

public class MyCustomView1 extends BaseView<MyCustomView1.Item,MyCustomView1.Listener> {

    @MyAttr(name = "size"
            , type = StyleableFinder.DIMENSION,defFloat = 100)
    float size;

    public MyCustomView1(Context context) {
        super(context);
    }

    public MyCustomView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
	
	@Override
    protected void onBind(Item item) {

    }
	
	public interface Item {

    }
	
	public interface Listener
    {

    }

}
