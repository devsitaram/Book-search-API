package com.example.api.post;

import androidx.annotation.NonNull;

import com.example.api.post.holper.BookPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookPresenter implements BookContract.Presenter{

    BookContract.View view;
    private final BookModel bookModel = new BookModel();

    @Override
    public void setBookData() {
        bookModel.getBookData().enqueue(new Callback<List<BookPojo>>() {
            @Override
            public void onResponse(@NonNull Call<List<BookPojo>> call, @NonNull Response<List<BookPojo>> response) {
                if (response.isSuccessful()){
                    view.showSuccessMessage(true);
                    view.setBook(response.body());
                }else {
                    view.showErrorMessage("Book is not available");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<BookPojo>> call, @NonNull Throwable throwable) {
                view.showErrorMessage(throwable.getMessage());
            }
        });
    }
}
