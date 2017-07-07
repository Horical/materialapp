package com.horical.hrc7.libsupports;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Billy Phan on 6/21/2017.
 */

public class HttpHelper {
    Retrofit retrofit;

    public HttpHelper(String baseUrl) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> T from(Class<T> service) {
        return (T) this.retrofit.create(service);
    }
}
