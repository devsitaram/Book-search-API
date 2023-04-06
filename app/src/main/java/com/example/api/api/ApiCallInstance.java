package com.example.api.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCallInstance {

    private static Retrofit retrofit;

    private static final String BASE_URL = "https://simple-books-api.glitch.me/books";

    public static Retrofit getRetrofitInstance(){
        if(retrofit == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder() //
                    .addInterceptor(httpLoggingInterceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()) // converter
                    .build();
        }
        return retrofit;
    }

    // new methods for getService
    public ApiCallInstance getService() {
        return retrofit.create(ApiCallInstance.class);
    }
}
