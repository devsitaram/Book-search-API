package com.example.api.books;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.api.books.helper.BooksPojo;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BooksPresenter implements BooksContract.Presenter {
    private final BooksContract.View mView;
    private final BooksModel booksModel = new BooksModel();

    public BooksPresenter(BooksContract.View view) {
        this.mView = view;
    }

    public void setBooks(int id) {
        booksModel.getBooks(id).enqueue(new Callback<List<BooksPojo>>() {
            @Override
            public void onResponse(@NonNull Call<List<BooksPojo>> call, @NonNull Response<List<BooksPojo>> response) {
                Log.d("BooksP", "here");
                if (response.isSuccessful()) {
//                    view.successMessage(true);
                Log.d("BooksP", "here");
                    mView.setBook(response.body());
                } else {
//                    view.errorMessage("Book is not available");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<BooksPojo>> call, @NonNull Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
