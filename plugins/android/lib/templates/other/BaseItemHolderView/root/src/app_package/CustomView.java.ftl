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
@MyLayout(<#if isCreateOnLib>name = "${viewLayout}"<#else>R.layout.${viewLayout}</#if>)
public class ${viewClass} extends BaseViewHolder<${viewClass}.Item,<#if includeCallbacks>${viewClass}.Listener<#else>Object</#if>> {

    public ${viewClass}(View itemView) {
        super(itemView);
    }

    @Override
    public void setupView() {
    }

    @Override
    public void bind(Item item) {
        super.bind(item);
        // TODO: binding data to view

    }
	
	public interface Item {

    }

<#if includeCallbacks>
	public interface Listener
    {
    }
</#if>
}
