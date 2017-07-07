package com.horical.hrc7.supplier.screen.login.dto;

/**
 * Created by Billy Phan on 6/24/2017.
 */

public class UserDTO {
    protected String username;
    protected String password;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
