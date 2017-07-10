package ${packageName};
import android.content.Context;
import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.dialog.BaseDialog;
import android.support.annotation.NonNull;
<#if applicationPackage??>
import ${applicationPackage}.R;
</#if>
/**
 * Created by HRC7 on 6/30/2017.
 */

@MyLayout(<#if isCreateOnLib>name="${escapeXmlAttribute(dialogName)}"<#else>R.layout.${escapeXmlAttribute(dialogName)}</#if>)
public class ${className} extends BaseDialog<${className}.Item,<#if includeCallbacks>${className}.Listener<#else>Object</#if>> {

    public ${className}(@NonNull Context context) {
        super(context);
    } 
	
	@Override
    protected void onBind(Item item) {

    }
	
	public interface Item {

    }

<#if includeCallbacks>
	public interface Listener
    {
    }
</#if>
}