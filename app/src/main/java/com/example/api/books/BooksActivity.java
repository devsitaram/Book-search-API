package com.example.api.books;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.api.R;
import com.example.api.books.helper.BooksPojo;
import com.example.api.database.Databases;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BooksActivity extends AppCompatActivity implements BooksContract.View {

    Databases databases;
    Book book;
    List<BooksPojo> booksPojoList;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    BooksPresenter booksPresenter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        booksPresenter = new BooksPresenter(this);
//        databases = Databases.getInstance(this);
        booksPresenter.setBooks(15);
    }

    // show the success message
    @Override
    public void successMessage(boolean show) {
        if (show) {
            if (progressDialog != null && !progressDialog.isShowing()) {
                progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("Loading ...");
                progressDialog.show();
            }
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        }
    }

    // show the error message
    @SuppressLint("ShowToast")
    @Override
    public void errorMessage(String message) {
        Toast.makeText(BooksActivity.this, message, Toast.LENGTH_LONG);
    }

    // this methods can be set the book list with body
    @Override
    public void setBook(@NonNull List<BooksPojo> body) {
        Log.d("Books",body.size() + "");
            RecyclerView recyclerView = findViewById(R.id.rvBooks);
            PostAdapter thisAdapter = new PostAdapter(body, BooksActivity.this);
            LinearLayoutManager layoutManager = new LinearLayoutManager(BooksActivity.this);

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(thisAdapter);
    }


    // this methods can be call the three functions
//    private void setInsertStudents() {
//        // call the insertStudents methods
//        insertBooks()
//                .subscribeOn(Schedulers.io())
//                .subscribe(new CompletableObserver() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable disposable) {
//                        compositeDisposable.add(disposable);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        setBookRecyclerView(); // call the setBookRecyclerView methods
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable throwable) {
//
//                    }
//                });
//    }


    // insert the new data
//    private Completable insertBooks() {
//        bookList = new ArrayList<>();
//        bookList.add(new Book("Teh v", "Manjil", "ram1010@gmail.com"));
//        bookList.add(new Book("v xcm ", "Manjil", "manjil5555@gmail.com"));
//        bookList.add(new Book("sdvv", "Sitaram", "sitaram1111@gmail.com"));
//        bookList.add(new Book("sv x", "Paurakh", "paurakh9876@gmail.com"));
//        bookList.add(new Book("j cx", "Chirayu", "chirayu1234@gmail.com"));
//
//        return databases.booksDao().insertAllBook(bookList);
//    }


    @SuppressLint("CheckResult")
    public void setBookRecyclerView() {
//        getBooks()
//                .subscribeOn(Schedulers.io())
//                .subscribe(students -> {
//                    PostAdapter studentAdapter = new PostAdapter(booksPojoList, this);
//                    recyclerView.setAdapter(studentAdapter);
//                    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//                    recyclerView.setLayoutManager(gridLayoutManager);
//
//                });
    }


    // this methods is available in Dao interface
    public Single<List<Book>> getBooks() {
//        return databases.booksDao().getAllBooks();
        return null;
    }

}