package ${packageName}.install;

import android.os.Bundle;

import com.horical.hrc7.lib_base.base.BaseActivity;
import com.horical.hrc7.lib_base.base.anotation.MyHandler;
import com.horical.hrc7.lib_base.base.anotation.MyServe;

import com.horical.hrc7.libbasetest.test.IMvpView;
<#if applicationPackage??>
import ${applicationPackage}.R;
</#if>

@MyHandler(${className}Handler.class)
@MyServe(${className}Serve.class)
public class ${activityClass} extends BaseActivity<I${className}View.Handler> implements I${className}View {
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.${layoutName});
    }
	
	@Override
    protected void setupView() {
	
    }
}