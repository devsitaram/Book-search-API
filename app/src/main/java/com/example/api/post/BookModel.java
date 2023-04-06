package com.example.api.post;

import com.example.api.api.APIServices;
import com.example.api.api.ApiCallInstance;
import com.example.api.post.holper.BookPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class BookModel implements BookContract.Model{
    @Override
    public Call<List<BookPojo>> getBookData() {
        Retrofit retrofit = ApiCallInstance.getRetrofitInstance();
        return retrofit.create(APIServices.class).getBookData();
    }
}
