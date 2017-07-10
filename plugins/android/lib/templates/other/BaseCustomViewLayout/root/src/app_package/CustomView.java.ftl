package ${packageName};

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.helper.finder.ViewFinder;

<#if applicationPackage??>
import ${applicationPackage}.R;
</#if>

/**
 * Created by HRC7 on 7/6/2017.
 */

@MyLayout(<#if isCreateOnLib>name="${escapeXmlAttribute(viewName)}"<#else>R.layout.${escapeXmlAttribute(viewName)}</#if>)
public class ${className} extends FrameLayout {
	Item item;
<#if includeCallbacks>
	Listener listener;
</#if>

    public ${className}(Context context) {
        super(context);
		onInit(null);
    }

    public ${className}(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
		onInit(attrs);
    }

    public ${className}(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
	
<#if includeCallbacks>
	public interface Listener
    {

    }
</#if>

}
