package ${packageName};
import android.view.View;
import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.lib_base.recycle_view.BaseViewHolder;
<#if applicationPackage??>
import ${applicationPackage}.R;
</#if>
/**
 * Created by HRC7 on 6/30/2017.
 */
@MyLayout(R.layout.item_view_${view_class})
public class Item${viewClass}Holder extends BaseViewHolder<Object, Item${viewClass}Holder.Listener> {

    public Item${viewClass}Holder(View itemView) {
        super(itemView);
    }

    @Override
    public void setupView() {
    }

    @Override
    protected void onBind(Object item) {
        
    }


    public interface Listener {
      
    }
}
