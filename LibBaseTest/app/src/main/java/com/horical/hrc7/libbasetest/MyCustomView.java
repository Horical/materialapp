package com.horical.hrc7.libbasetest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.helper.finder.ViewFinder;


/**
 * Created by HRC7 on 7/6/2017.
 */

@MyLayout(name="view_my_custom_view")
public class MyCustomView extends FrameLayout {
	Item item;
	Listener listener;

    public MyCustomView(Context context) {
        super(context);
		onInit(null);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
		onInit(attrs);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
		onInit(attrs);
    }
	
	private void onInit(AttributeSet attrs) {
        ViewFinder.load(this);
    }
	
	public void bind(Item item)
	{
		this.item = item;
	}
	
	public interface Item {

    }
	
	public void setListener(Listener listener) {
        this.listener = listener;
    }
	
	public interface Listener
    {

    }

}
