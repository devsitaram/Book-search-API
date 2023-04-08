package com.example.api.books;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.api.R;

public class BooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        BooksPresenter booksPresenter = new BooksPresenter();
        booksPresenter.setBooks(15);
    }
}