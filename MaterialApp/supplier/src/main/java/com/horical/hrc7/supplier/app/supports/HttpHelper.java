package com.horical.hrc7.supplier.app.supports;

import com.horical.hrc7.supplier.app.AppConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Billy Phan on 6/21/2017.
 */

public class HttpHelper {
    Retrofit retrofit;

    public HttpHelper() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> T from(Class<T> service) {
        return (T) this.retrofit.create(service);
    }
}
