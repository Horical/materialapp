package ${packageName};

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.horical.hrc7.lib_base.custom_view.BaseView;
import com.horical.hrc7.lib_base.helper.finder.MyAttr;
import com.horical.hrc7.lib_base.helper.finder.StyleableFinder;
<#if applicationPackage??>
import ${applicationPackage}.R;
</#if>

/**
 * Created by HRC7 on 7/6/2017.
 */

public class ${className} extends BaseView<${className}.Item,<#if includeCallbacks>${className}.Listener<#else>Object</#if>> {

    @MyAttr(<#if isCreateOnLib>name = "size"<#else>id = R.styleable.${className}_size</#if>
            , type = StyleableFinder.DIMENSION,defFloat = 100)
    float size;

    public ${className}(Context context) {
        super(context);
    }

    public ${className}(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ${className}(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
	
	@Override
    protected void setupView() {

    }

    @Override
    public void bind(Item item) {
        super.bind(item);
        // TODO: bind data to view

    }
	
	public interface Item {

    }
	
<#if includeCallbacks>
	public interface Listener
    {

    }
</#if>

}
