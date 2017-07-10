package ${packageName};

import android.os.Bundle;
import com.horical.hrc7.lib_base.fragment.BaseFragment;
import com.horical.hrc7.lib_base.helper.finder.MyLayout;

<#if applicationPackage??>
import ${applicationPackage}.R;
</#if>

/**
 * Created by HRC7 on 7/4/2017.
 */

@MyLayout(<#if isCreateOnLib>name="${escapeXmlAttribute(fragmentName)}"<#else>R.layout.${escapeXmlAttribute(fragmentName)}</#if>)
public class ${className} extends BaseFragment<${className}.Item, <#if includeCallbacks>${className}.Listener<#else>Object</#if>> {
<#if includeFactory>
    private static final String ARG_PARAM = "ARG_PARAM";
    private String param;

    public ${className}() {
	
    }

    public static ${className} newInstance(String param) {
        ${className} fragment = new ${className}();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param = getArguments().getString(ARG_PARAM);
        }
    }
</#if>

    @Override
    protected void setupView() {
	
    }
	
	
	@Override
    protected void onBind(Item item) {

    }

	public interface Item {

    }
	
<#if includeCallbacks>
    public interface Listener {
    }
</#if>
}
