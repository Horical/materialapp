package com.horical.hrc7.materialapp.login.install;

import android.content.Intent;

import com.horical.hrc7.lib_base.base.BaseServe;
import com.horical.hrc7.materialapp.login.ILoginServe;
import com.horical.hrc7.materialapp.login.view_struct.IUserLogin;
import com.horical.hrc7.materialapp.login.view_struct.UserLogin;
import com.horical.hrc7.supplier.app.AppManager;
import com.horical.hrc7.supplier.network_api.login.UserAPI;
import com.horical.hrc7.supplier.network_api.login.dto.UserDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Billy Phan on 6/24/2017.
 */

public class LoginServe extends BaseServe<ILoginServe.Handler> implements ILoginServe, Callback<UserDTO> {
    UserAPI userAPI;

    @Override
    protected void onInit(Intent intent) {
        userAPI = AppManager.getHttpManager().from(UserAPI.class);
    }

    @Override
    public void loadFormHint() {
        userAPI.loadUserHint()
                .enqueue(this);
    }

    @Override
    public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
        IUserLogin userLogin = UserLogin.from(response.body());
        if (response.isSuccessful()) getHandler().onLoadUserHintSuccess(userLogin);
        else getHandler().onLoadUserHintFail(response.message());
    }

    @Override
    public void onFailure(Call<UserDTO> call, Throwable t) {
        getHandler().onLoadUserHintFail(t.getMessage());

    }
}
