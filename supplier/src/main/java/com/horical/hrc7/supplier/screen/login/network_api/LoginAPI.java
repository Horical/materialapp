package com.horical.hrc7.supplier.screen.login.network_api;


import com.horical.hrc7.supplier.screen.login.dto.UserDTO;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Billy Phan on 6/24/2017.
 */

public interface LoginAPI {
    @GET("/")
    Call<UserDTO> loadUserHint();
}
