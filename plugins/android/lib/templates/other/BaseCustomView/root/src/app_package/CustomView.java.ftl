package ${packageName};

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.horical.hrc7.lib_base.custom_view.BaseView;
import com.horical.hrc7.lib_base.helper.finder.MyAttr;
import com.horical.hrc7.lib_base.helper.finder.StyleableFinder;
import ${applicationPackage}.R;

/**
 * Created by HRC7 on 7/6/2017.
 */

public class ${className} extends BaseView<String,<#if includeCallbacks>${className}.Listener<#else>Object</#if>> {

    @MyAttr(attr = R.styleable.${className}_size
            , type = StyleableFinder.DIMENSION)
    float size = 100;

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
    protected void onBind(String item) {

    }
	
<#if includeCallbacks>
	public interface Listener
    {

    }
</#if>

}
