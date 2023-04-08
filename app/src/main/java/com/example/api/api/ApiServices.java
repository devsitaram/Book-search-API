package com.example.api.api;

import com.example.api.books.helper.BooksPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiServices {

    @Headers({"Content-Type: application/json",
            "X-RapidAPI-Key: 9e20034fd9msh152d8e07f3542bcp15f9efjsne0833ef8a71e",
            "X-RapidAPI-Host: project-gutenberg-api.p.rapidapi.com"})
    @GET("books/{id}.json")
    Call<List<BooksPojo>> getBooks(@Path("id") int bookId);
}
