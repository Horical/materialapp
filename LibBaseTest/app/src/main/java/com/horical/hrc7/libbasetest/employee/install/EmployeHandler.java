package com.horical.hrc7.libbasetest.employee.install;


import com.horical.hrc7.lib_base.base.BaseHandler;
import com.horical.hrc7.libbasetest.employee.IEmployeServe;
import com.horical.hrc7.libbasetest.employee.IEmployeView;

public class EmployeHandler extends BaseHandler<IEmployeView, IEmployeServe> implements IEmployeView.Handler, IEmployeServe.Handler {
    @Override
    protected void onInit() {

    }

    @Override
    public void onBtnClicked() {
    }

    @Override
    public void onPermissionsAccepted() {
        getView().toast("Permission accepted");
    }

    @Override
    public void onPermissionsDenied() {
        getView().toast("Permission denied");
    }
}