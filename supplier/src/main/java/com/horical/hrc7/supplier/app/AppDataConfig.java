package com.horical.hrc7.supplier.app;

/**
 * Created by Billy Phan on 6/24/2017.
 */

public class AppDataConfig {
    private static final String TOKEN = "TOKEN";
    private String token = null;

    public void setToken(String token) {
        this.token = token;
        AppManager.cache().prefer().save(TOKEN, token);
    }

    public String getToken() {
        if (token == null)
            token = AppManager.cache().prefer().load(TOKEN, "");
        return token;
    }
}
