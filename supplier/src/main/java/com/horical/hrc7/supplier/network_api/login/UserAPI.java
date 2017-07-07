package com.horical.hrc7.supplier.network_api.login;


import com.horical.hrc7.supplier.network_api.login.dto.UserDTO;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Billy Phan on 6/24/2017.
 */

public interface UserAPI {
    @GET("/")
    Call<UserDTO> loadUserHint();
}
