package com.horical.hrc7.materialapp.login;


import com.horical.hrc7.materialapp.login.view_struct.IUserLogin;

/**
 * Created by Billy Phan on 6/24/2017.
 */

public interface ILoginServe {
    void loadFormHint();

    interface Handler {
        void onLoadUserHintFail(String message);

        void onLoadUserHintSuccess(IUserLogin body);
    }
}
