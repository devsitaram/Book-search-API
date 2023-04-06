package com.example.api.api;

import com.example.api.post.holper.BookPojo;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices {

    @GET("/books")
    Call<List<BookPojo>> getBookData();
}
