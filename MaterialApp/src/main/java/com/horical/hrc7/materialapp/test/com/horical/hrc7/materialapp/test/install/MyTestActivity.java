package com.horical.hrc7.materialapp.test;

import com.horical.hrc7.lib_base.*;

@MyHandler(MyTestHandler.class)
@MyServe(MyTestServe.class)
public class MyTestActivity extends BaseActivity<IMyTestView.Handler> implements IMyTestView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_MyTest);
    }

    @Override
    protected void setupView() {

    }
}