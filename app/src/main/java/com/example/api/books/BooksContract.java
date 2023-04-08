package com.example.api.books;

import com.example.api.books.helper.BooksPojo;

import java.util.List;

import retrofit2.Call;

public interface BooksContract {
    interface View{
        void successMessage(boolean show);
        void errorMessage(String message);
        void setBooks(List<BooksPojo> body);
    }

    interface Presenter{
        void setBooks(int id);
    }

    interface Model{
        Call<List<BooksPojo>> getBooks(int id);
    }
}
