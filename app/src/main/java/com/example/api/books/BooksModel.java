package com.example.api.books;
import com.example.api.api.ApiCallInstance;
import com.example.api.api.ApiServices;
import com.example.api.books.helper.BooksPojo;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;

public class BooksModel implements BooksContract.Model {
    @Override
    public Call<List<BooksPojo>> getBooks(int id) {
        Retrofit retrofit = ApiCallInstance.getRetrofitInstance();
        return retrofit.create(ApiServices.class).getBooks(id);
    }
}
