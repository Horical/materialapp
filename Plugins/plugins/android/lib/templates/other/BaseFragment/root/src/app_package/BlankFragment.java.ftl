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

@MyLayout(R.layout.${escapeXmlAttribute(fragmentName)})
public class ${className} extends BaseFragment<String, <#if includeCallbacks>${className}.Listener<#else>Object</#if>> {
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
    protected void onBind(String item) {
    }
<#if includeCallbacks>
    public interface Listener {
    }
</#if>
}
