package com.example.api.post;

import com.example.api.post.holper.BookPojo;

import java.util.List;

import retrofit2.Call;

public interface BookContract {
    interface View {
        void showSuccessMessage(boolean show);
        void showErrorMessage(String errorMessage);
        void setBook(List<BookPojo> body);
    }

    interface Presenter {
        void setBookData();
    }

    interface Model{
        Call<List<BookPojo>> getBookData();
    }
}
