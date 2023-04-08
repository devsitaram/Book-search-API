package com.example.api.books;

import androidx.annotation.NonNull;

import com.example.api.books.helper.BooksPojo;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BooksPresenter implements BooksContract.Presenter {
    private BooksContract.View view;
    private final BooksModel booksModel = new BooksModel();

    public void setBooks(int id) {
        booksModel.getBooks(id).enqueue(new Callback<List<BooksPojo>>() {
            @Override
            public void onResponse(@NonNull Call<List<BooksPojo>> call, @NonNull Response<List<BooksPojo>> response) {
                if (response.isSuccessful()){
                    view.successMessage(true);
                    view.setBooks(response.body());
                }else {
                    view.errorMessage("Book is not available");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<BooksPojo>> call, @NonNull Throwable throwable) {
                view.errorMessage(throwable.getMessage());
            }
        });
    }
}
