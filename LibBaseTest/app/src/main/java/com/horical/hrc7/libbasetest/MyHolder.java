package com.horical.hrc7.libbasetest;
import android.view.View;
import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.lib_base.recycle_view.BaseViewHolder;
/**
 * Created by HRC7 on 6/30/2017.
 */
@MyLayout(name = "item_view_my_holder")
public class MyHolder extends BaseViewHolder<MyHolder.Item,MyHolder.Listener> {

    public MyHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setupView() {
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
