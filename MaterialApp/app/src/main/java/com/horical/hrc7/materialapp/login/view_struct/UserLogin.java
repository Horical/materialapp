package com.horical.hrc7.materialapp.login.view_struct;


import com.horical.hrc7.supplier.network_api.login.dto.UserDTO;

/**
 * Created by Billy Phan on 6/24/2017.
 */

public class UserLogin implements IUserLogin {
    private String name;
    private String pass;

    public UserLogin(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public String getPassword() {
        return pass;
    }

    public static UserLogin from(UserDTO userDTO) {
        return new UserLogin(userDTO.getUsername(), userDTO.getPassword());
    }
}
